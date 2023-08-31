package celerium.com.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MakeMariaFiles {

	public static void main(String[] args) {
		final String baseDirectory = "C:\\Users\\EricaKeyes\\Documents\\GitHub\\cdnservices\addingsomething";
			
		File srcDir = new File(baseDirectory);

		for (File dir : srcDir.listFiles())
        {
           if ( dir.isDirectory()) {
        	   
        	   for (File file : dir.listFiles())
               {
                  if (file.isFile())
                  {
                	  System.out.println("file is "+file.getName());
                	  System.out.println("file is "+file.getPath().replace("-oracle","-mariadb"));
                	  String newFileName = file.getPath().replace("-oracle","-mariadb");
                	  FileOutputStream out = null;
                	  try {
						  out = new FileOutputStream(newFileName);
						  Path path = Paths.get( file.getPath());
						  Files.copy( path, out);
					} catch (IOException e) {
						System.out.println("IO ERROR : "+e.toString());
						e.printStackTrace();
					}finally
                	 {
						 try
				            {
				                out.close();
				            }
				            catch (IOException e1)
				            {
				                e1.printStackTrace();
				            }
                	  }
                  }
               }     
           }
        }
	}

}
