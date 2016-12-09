/*
 https://github.com/aakash7864/External-Hadoop-Spark-Sorting-App/blob/master/Source/External/src/ThreadedSharedMemSort.java
 */
package ru.isalnikov.acase.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * Program to sort data set having for larger size than memory. Program takes
 * input file generated from gensort and consider first 10bytes as key and
 * remaining 90 bytes as value. Program uses producer - consumer approach to
 * read and write sorted data files into chunks based on number of lines.
 * Program uses K-way Merge Sort algorithm with the help of priority queue to
 * merge sorted file chunks to a new File Chunks having all file records in
 * sorted order
 * </p>
 * 
 * @author Aishwarya Anand (A20331867)
 * @mail aanand12@hawk.iit.edu
 * 
 */
public class ThreadedSharedMemSort {

	/**
	 * Starting point of program to perform shared memory merge sort Program
	 * takes input in below format
	 * 
	 * @param args0
	 *            - inputfile - File to sort
	 * @param args1
	 *            - output folder - Directory to store sorted file chunks and
	 *            produce output as output.txt
	 * @param args2
	 *            - total number of records present in input file
	 * @param args3
	 *            - Number of lines from where file will be splited
	 * @param args4
	 *            - Number of Threads to run as consumer
	 * @param args5
	 *            - Max size of queue for producer - consumer
	 * @param args6
	 *            - Time for thread to sleep if queue is full in ms -
	 */
	public static void main(String[] args) {
		try {
			BlockingQueue<List<String>> queue = new LinkedBlockingQueue<>();
			String inputfile = args[0];
			Long numberOfLineToSplitOn = Long.valueOf(args[3]);
			Long startTime = System.currentTimeMillis();
			long totalNumberOfRecords = Long.valueOf(args[2]);
			double toatlFileChunks = (totalNumberOfRecords / numberOfLineToSplitOn);
			int absValue = (int) toatlFileChunks;
			int numberOfFile = 0;
			/*
			 * Logic to create number of files. Comparing int with double value
			 * because
			 */
			if (absValue == toatlFileChunks) {
				// If total chunk is absolute value then we don't need to do
				// anything
				numberOfFile = absValue;
			} else {
				// other wise we need to create one more file to store remaining
				// values
				numberOfFile = absValue + 1;
			}
			System.out.println("No. of files to be generated :" + numberOfFile);
			// Creating Stream because we can read large file in stream.
			FileInputStream fstream = new FileInputStream(inputfile);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			// Number of consumer Thread to work on Queue
			int numOfThreads = Integer.parseInt(args[4]);
			Thread consumerThreadPool[] = new Thread[numOfThreads];
			/*
			 * Creating array of runnable task, So that after execution of all
			 * task we could cancel all thread or wait for them to complete
			 */
			FileSorterAndWriter[] sorterList = new FileSorterAndWriter[numOfThreads];
			for (int j = 0; j < numOfThreads; j++) {
				sorterList[j] = new FileSorterAndWriter(queue, args[1], numberOfFile * j);
				consumerThreadPool[j] = new Thread(sorterList[j]);
				consumerThreadPool[j].start();
			}
			System.out.println("No. of consumer threads created:" + numOfThreads);

			/*
			 * Producer that reads data from large file and split it on chunk
			 * and put them in queue for processing
			 */
			String strLine;
			for (int j = 1; j <= numberOfFile; j++) {
				ArrayList<String> tempList = new ArrayList<>();
				for (int i = 1; i <= numberOfLineToSplitOn; i++) {
					strLine = br.readLine();
					if (strLine != null) {
						tempList.add(strLine);
						if (i != numberOfLineToSplitOn) {
							// Do Nothing
						}
					}
				}
				queue.add(tempList);
				while (queue.size() >= Integer.valueOf(args[5])) {
					Thread.sleep(Integer.valueOf(args[6]));
				}
				// System.out.println("Queue Size " + queue.size());
			}

			in.close();

			/*
			 * When all data are added to queue we need to wait for all task to
			 * be finished by consumer thread
			 */
			while (true) {
				if (queue.isEmpty()) {
					// Waiting main thread
					Thread.sleep(Integer.valueOf(args[6]));
					for (int j = 0; j < numOfThreads; j++) {
						sorterList[j].cancelExecution();
					}
					break;
				}
			}
			/*
			 * Synchronizing all thread with main thread
			 */
			for (int i = 0; i < numOfThreads; i++) {
				consumerThreadPool[i].join();
			}

			File intermediaryDataFolder = new File(args[1] + "//");
			File[] listOfFiles = intermediaryDataFolder.listFiles();
			List<File> fileList = new ArrayList<File>(Arrays.asList(listOfFiles));
			/*
			 * Merging Files using priority queue.
			 */
			loadFilesAndMergefiles(fileList, new File(args[1] + "//output.txt"));
			System.out.println("Process Finshed in time " + (System.currentTimeMillis() - startTime) + " ms");
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}

	}

	/**
	 * Compare Two String
	 */
	public static int compareString(String str1, String str2) {
		return str1.compareTo(str2);
	}

	/**
	 * creates a sorted file using priority queue. Priority queue takes all
	 * buffer reader of file chunks
	 * 
	 * @param fbw
	 *            - Writer for creating merge Files
	 * @param buffers
	 *            - list of all buffers for all file chunks
	 * @throws IOException
	 */
	public static void mergeSortedFilesUsingPriorotyQueue(BufferedWriter fbw, List<RecordReader> buffers) throws IOException {
		PriorityQueue<RecordReader> priorityQueue = new PriorityQueue<RecordReader>(10000, new Comparator<RecordReader>() {
			@Override
			public int compare(RecordReader i, RecordReader j) {
				return compareString(i.getKey(), j.getKey());
			}
		});
		addBufferToPriorityQueue(buffers, priorityQueue);
		try {
			while (priorityQueue.size() > 0) {
				RecordReader bfb = priorityQueue.poll();
				String r = bfb.getLine();
				fbw.write(r);
				fbw.newLine();
				if (bfb.isEmpty()) {
					bfb.buffer.close();
				} else {
					priorityQueue.add(bfb); // add it back
				}
			}
		} finally {
			closeAllBuffers(fbw, priorityQueue);
		}

	}

	/**
	 * Adding buffer to priority queue if empty
	 * 
	 * @param buffers
	 *            - list of all buffers for all file chunks
	 * @param priorityQueue
	 *            - Queue that sort files based on priority
	 */
	private static void addBufferToPriorityQueue(List<RecordReader> buffers, PriorityQueue<RecordReader> priorityQueue) {
		for (RecordReader bfb : buffers) {
			if (!bfb.isEmpty()) {
				priorityQueue.add(bfb);
			}
		}
	}

	/**
	 * Closes all buffers when work is done
	 * 
	 * @param fbw
	 *            - buffer for output file
	 * @param priorityQueue
	 *            - Queue that contains all buffers
	 * @throws IOException
	 */
	private static void closeAllBuffers(BufferedWriter fbw, PriorityQueue<RecordReader> priorityQueue) throws IOException {
		fbw.close();
		for (RecordReader bfb : priorityQueue) {
			bfb.closeBuffer();
		}
	}

	/**
	 * Loads all files using buffer reader and creates a buffer writer to
	 * generate sorted output file
	 * 
	 * @param files
	 *            - List of file chunks
	 * @param outputfile
	 *            - OutputFile
	 * @throws IOException
	 */
	public static void loadFilesAndMergefiles(List<File> files, File outputfile) throws IOException {
		ArrayList<RecordReader> bfbs = new ArrayList<RecordReader>();
		BufferedWriter fbw = createBuffersForAllChunkFiles(files, outputfile, bfbs);
		mergeSortedFilesUsingPriorotyQueue(fbw, bfbs);
		deleteAllFilesAfterMerging(files);
	}

	/**
	 * Deletes all file chunks
	 * 
	 * @param files
	 *            - file chunks
	 */
	private static void deleteAllFilesAfterMerging(List<File> files) {
		for (File file : files) {
			file.delete();
		}
	}

	/**
	 * Function to crate file buffer for all files and buffer writer for output
	 * file
	 * 
	 * @param files
	 *            - file chunks
	 * @param outputfile
	 *            - output File
	 * @param bfbs
	 *            - List of buffers of file chunks
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static BufferedWriter createBuffersForAllChunkFiles(List<File> files, File outputfile, ArrayList<RecordReader> bfbs) throws FileNotFoundException,
			IOException {
		for (File f : files) {
			InputStream in = new FileInputStream(f);
			BufferedReader br;
			br = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
			RecordReader bfb = new RecordReader(br);
			bfbs.add(bfb);
		}
		BufferedWriter fbw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputfile, true), Charset.forName("UTF-8")));
		return fbw;
	}

	/**
	 * Consumer class to read Number of records from queue to sort them and then
	 * store them at disk
	 * 
	 */
	static class FileSorterAndWriter implements Runnable {
		private BlockingQueue<List<String>> jobQueue;
		private volatile boolean keepProcessing;
		private int value;
		private String location;

		/**
		 * @param queue
		 *            - localQueue
		 * @param folderlocation
		 *            - folder to create file
		 * @param totalFile
		 *            - total number of files to creates
		 */
		public FileSorterAndWriter(BlockingQueue<List<String>> queue, String folderlocation, int totalFile) {
			jobQueue = queue;
			keepProcessing = true;
			this.value = totalFile;
			this.location = folderlocation;
		}

		public void run() {

			while (keepProcessing) {
				if (!jobQueue.isEmpty()) {
					try {
						List<String> recordsList = jobQueue.poll(1, TimeUnit.SECONDS);

						if (recordsList != null) {
							FileWriter fstream1;
							try {
								HashMap<String, String> tempMap = new HashMap<>();
								for (String strLine : recordsList) {
									tempMap.put(strLine.substring(0, 10), strLine.substring(10));
								}
								Set<String> keys = tempMap.keySet();
								String[] keysArray = keys.toArray(new String[keys.size()]);
								quicksort(keysArray, 0, keysArray.length - 1);
								fstream1 = new FileWriter(this.location + "//" + this.value + ".txt");
								BufferedWriter out = new BufferedWriter(fstream1);
								for (int l = 0; l < keysArray.length; l++) {
									String value = keysArray[l] + tempMap.get(keysArray[l]);
									out.write(value);
									out.newLine();
								}
								out.close();
								this.value++;
							} catch (IOException e) {
								e.printStackTrace();
							}

						}
					} catch (InterruptedException ie) {
						Thread.currentThread().interrupt();
						return;
					}
				} else {
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}

		/**
		 * cancel execution of thread
		 */
		public void cancelExecution() {
			this.keepProcessing = false;
		}

		/**
		 * Quick Sort using recursion
		 * 
		 * @param arr
		 *            - array to sort
		 * @param p
		 *            -
		 * @param r
		 *            -
		 */
		private void quicksort(String[] arr, int p, int r) {
			if (p < r) {
				int q = partition(arr, p, r);
				if (q == r) {
					q--;
				}
				quicksort(arr, p, q);
				quicksort(arr, q + 1, r);
			}
		}

		/**
		 * @param arr
		 * @param p
		 * @param r
		 * @return
		 */
		private int partition(String[] arr, int p, int r) {
			String pivot = arr[p];
			int lo = p;
			int hi = r;

			while (true) {
				while (arr[hi].compareTo(pivot) >= 0 && lo < hi) {
					hi--;
				}
				while (arr[lo].compareTo(pivot) < 0 && lo < hi) {
					lo++;
				}
				if (lo < hi) {
					String T = arr[lo];
					arr[lo] = arr[hi];
					arr[hi] = T;
				} else
					return hi;
			}
		}
	}

}

class RecordReader {

	public BufferedReader buffer;

	private String key;

	private String value;

	public RecordReader(BufferedReader r) throws IOException {
		this.buffer = r;
		parseLineForKeyAndVal();
	}

	public void closeBuffer() throws IOException {
		this.buffer.close();
	}

	public boolean isEmpty() {
		return this.key == null;
	}

	public String getKey() {
		return this.key;
	}

	public String getLine() throws IOException {
		String answer = getKey().toString() + this.value + "\t";
		parseLineForKeyAndVal();
		return answer;
	}

	private void parseLineForKeyAndVal() throws IOException {
		String line = this.buffer.readLine();
		if (line != null) {
			this.key = line.substring(0, 10);
			this.value = line.substring(10);
		} else {
			this.key = line;
			this.value = line;
		}
	}

}