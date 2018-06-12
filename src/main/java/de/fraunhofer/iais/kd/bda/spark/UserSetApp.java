package de.fraunhofer.iais.kd.bda.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class UserSetApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String inputFile = "resources/last-fm-sample1000000.tsv";
		String appName = "UserSetApp";

		SparkConf conf = new SparkConf().setAppName(appName).setMaster("local[*]");

		JavaSparkContext context = new JavaSparkContext(conf);

		JavaRDD<String> input = context.textFile(inputFile);

		// Extracting artist and username
		JavaPairRDD<String, UserSet> artistUsers = input.mapToPair(line -> {
			String[] rows = line.split("\\t");

			return new Tuple2<String, UserSet>(rows[3], new UserSet().add(rows[0]));
		});

		// Aggregating the usernames to the userSet of an artist
		JavaPairRDD<String, UserSet> artistUserNames = artistUsers.aggregateByKey(new UserSet(), (a, b) -> a.add(b),
				(a, b) -> a.add(b));

		artistUserNames.repartition(1).saveAsTextFile("/tmp/artistUserNames.txt");
		context.close();
	}// end main

}
