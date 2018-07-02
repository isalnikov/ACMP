package ru.isalnikov.sportloto.logworker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class FileReaderWorker extends SwingWorker<List<String>, String> {

    private File file;
    private JTextArea ta;

    public FileReaderWorker(File file, JTextArea ta) {
        this.file = file;
        this.ta = ta;
    }

    public File getFile() {
        return file;
    }

    public JTextArea getTextArea() {
        return ta;
    }

    @Override
    protected List<String> doInBackground() throws Exception {
        List<String> contents = new ArrayList<>(256);
        try (BufferedReader br = new BufferedReader(new FileReader(getFile()))) {
            String text = null;
            while ((text = br.readLine()) != null) {
                // You will want to deal with adding back in the new line characters
                // here if that is important to you...
                contents.add(text);
                publish(text);
            }
        }
        return contents;
    }

    @Override
    protected void done() {
        try {
            get();
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
            // Handle exception here...
        }
    }

    @Override
    protected void process(List<String> chunks) {
        JTextArea ta = getTextArea();
        for (String text : chunks) {
            ta.append(text);
        }
    }
    

}