package io.github.coalangsoft.visit;

import io.github.coalangsoft.lib.data.Func;
import io.github.coalangsoft.lib.data.ImutablePair;
import io.github.coalangsoft.lib.data.Pair;

import java.util.ArrayList;

public class Visitor {
	
	{
		functions = new ArrayList<Pair<Class<?>,Func<Object,Void>>>();
	}
	
	private ArrayList<Pair<Class<?>, Func<Object,Void>>> functions;
	
	public void addFunction(Class<?> c, Func<Object,Void> f){
		functions.add(new ImutablePair<Class<?>, Func<Object,Void>>(c, f));
	}

	public void handle(Object o) {
		for(int k = 0; k < functions.size(); k++){
			Pair<Class<?>, Func<Object, Void>> p = functions.get(k);
			if(p.getA().isInstance(o)){
				p.getB().call(o);
			}
		}
	}
	
}
