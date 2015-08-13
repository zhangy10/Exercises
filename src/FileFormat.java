import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileFormat {

	public static void main(String[] args) {
		//
		// Path path =
		// FileSystems.getDefault().getPath("/Users/zhangyu/Desktop/aa.txt");
		// System.out.println(path.toString());

		File file = new File("/Users/zhangyu/Desktop/aa.txt");
		File newFile = new File("/Users/zhangyu/Desktop/bb.txt");
		// System.out.println(file.exists() ? "true" : "false");
		BufferedReader reader = null;
		BufferedWriter writer = null;
		String readStr = null;
		try {
			reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(file)));
			writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(newFile)));
			while ((readStr = reader.readLine()) != null) {
				readStr = readStr.substring(4, readStr.length());
				System.out.println(readStr);
				writer.write(readStr);
				writer.newLine();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (reader != null) {
					reader.close();
				}
				if (writer != null) {
					writer.close();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
