package de.fraunhofer.iais.kd.bda.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

public class UserClicks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String inputFile = "resources/last-fm-sample1000000.tsv";
		String appName = "UserClicks";

		SparkConf conf = new SparkConf().setAppName(appName).setMaster("local[*]");

		JavaSparkContext context = new JavaSparkContext(conf);

		JavaRDD<String> input = context.textFile(inputFile);

		// Creating tuples (user,1)
		JavaPairRDD<String, Integer> artistsOne = input.mapToPair(line -> {
			String[] parts = line.split("\\t");
			return new Tuple2<String, Integer>(parts[3], new Integer(1));
		});

		// Counting the clicks per one user.
		JavaPairRDD<String, Integer> artistCount = artistsOne.reduceByKey((a, b) -> a + b);

		artistCount.repartition(1).saveAsTextFile("/tmp/artistCount.txt");
		context.close();
	}
}
