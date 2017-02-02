package test.visit;

import java.io.File;

import io.github.coalangsoft.lib.data.Func;
import io.github.coalangsoft.visit.Visitor;

public class FileVisitTest {
	
	public static void main(String[] args) {
		final Visitor v = new Visitor();
		v.addFunction(File.class, new Func<Object, Void>() {
			
			@Override
			public Void call(Object p) {
				File f = (File) p;
				if(f.isDirectory()){
					File[] children = f.listFiles();
					if(children == null){
						return null;
					}
					for(int i = 0; i < children.length; i++){
						v.handle(children[i]);
					}
				}
				return null;
			}
			
		});
		v.addFunction(File.class, new Func<Object, Void>() {
			
			@Override
			public Void call(Object p) {
				if(((File) p).isFile()){
					System.out.println(p);
				}
				return null;
			}
		});
		
		v.handle(new File("."));
	}
	
}
