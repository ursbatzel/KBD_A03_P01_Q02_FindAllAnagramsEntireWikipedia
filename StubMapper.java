package my;
import java.io.IOException;
import java.util.Arrays;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class StubMapper extends Mapper<Object, Text, Text, Text> {

	@Override
	public void map(Object key, Text value, Context context)
			throws IOException, InterruptedException {

		//A4 P1-2

		String[] words = value.toString().replaceAll("[^a-zA-Z \t]", "").split("[ \t]+");
		char[] letters;

		for(String word:words) {

			letters = word.toLowerCase().toCharArray();
			Arrays.sort(letters);
			context.write(new Text(String.valueOf(letters)), new Text(word));
			// System.out.println("MAP: " + String.valueOf(letters) + " " + word);
		}
	}
}
