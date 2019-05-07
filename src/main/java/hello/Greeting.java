package hello;

import java.util.ArrayList;

public class Greeting {

private final long id;

private final String content;

private ArrayList<String> nameArr = new ArrayList<String>() {{

add("Victor");

add("Dillion");

add("Daniel");

}};

public Greeting(long id, String content) {

this.id = id;

this.content = content;

}

public long getId() {

return id;

}

public String getContent() {

return content;

}

public ArrayList<String> getNames() {

return nameArr;

}

// POST methods

public void addName(String name) {

nameArr.add(name);

}

}
