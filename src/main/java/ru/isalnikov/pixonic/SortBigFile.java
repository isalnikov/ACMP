
package ru.isalnikov.pixonic;

//1. Есть данные которые превышают объем оперативной памяти. Необходимо отсортировать (пойдет даже текстовое описание, саму программу не обязательно писать).

import static java.nio.file.Files.lines;
import java.util.Arrays;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;

public class SortBigFile {

//  
//    private static final FlatMapFunction<String, String> WORDS_EXTRACTOR
//            = new FlatMapFunction<String, String>() {
//                @Override
//                public Iterable<String> call(String s) throws Exception {
//                    return Arrays.asList(s.split(" "));
//                }
//            };
//
//    private static final PairFunction<String, String, Integer> WORDS_MAPPER
//            = new PairFunction<String, String, Integer>() {
//                @Override
//                public Tuple2<String, Integer> call(String s) throws Exception {
//                    return new Tuple2<String, Integer>(s, 1);
//                }
//            };
//
//    private static final Function2<Integer, Integer, Integer> WORDS_REDUCER
//            = new Function2<Integer, Integer, Integer>() {
//                @Override
//                public Integer call(Integer a, Integer b) throws Exception {
//                    return a + b;
//                }
//            };

    
    public static void main(String[] args) {
//      sparkContext.textFile("hdfs://...")
//            .flatMap(line => line.split(" "))
//            .map(word => (word, 1)).reduceByKey(_ + _)
//            .saveAsTextFile("hdfs://...")
        
        
        String inputFileName = "samples/big.txt" ; 
        String outputDirName = "output" ; 
        
        
        SparkConf conf = new SparkConf()
                .setAppName("ru.isalnikov.pixonic.Sort")
                .setMaster("local[*]");
        
        JavaSparkContext context = new JavaSparkContext(conf);
        
        
         JavaRDD<String> lines = context.textFile(inputFileName);
         
         //lines.mapToPair(null)
    //,
         
//         counter.saveAsTextFile(outputDirName); 
//        
//        JavaRDD<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
//            public Iterable<String> call(String s) {
//                return Arrays.asList(s.split(" "));
//                }
//            });
    }
    
}
