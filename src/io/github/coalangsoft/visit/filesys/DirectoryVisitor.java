package io.github.coalangsoft.visit.filesys;

import java.io.File;

import io.github.coalangsoft.lib.data.Func;
import io.github.coalangsoft.visit.Visitor;
import io.github.coalangsoft.visit.VisitorInfo;

@VisitorInfo(File.class)
public class DirectoryVisitor implements Func<Object, Void>{

	private Visitor base;

	public DirectoryVisitor(Visitor base){
		this.base = base;
	}
	
	@Override
	public Void call(Object p) {
		File f = (File) p;
		if(f.isDirectory()){
			File[] children = f.listFiles();
			if(children != null){
				for(int i = 0; i < children.length; i++){
					base.handle(children[i]);
				}
			}
		}
		return null;
	}

}
