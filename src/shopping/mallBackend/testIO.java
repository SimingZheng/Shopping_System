package shopping.mallBackend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class testIO {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Process proc;
        try {
            String[] args1 = new String[] { "python", "src/shopping/mallBackend/Product_Recommend.py", "juicer"};
            proc = Runtime.getRuntime().exec(args1);
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}