package io.deep27soft.spring_boot_demo.model;

import java.util.Objects;

public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (int) id;
        hash = 31 * hash + content.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Greeting)) {
            return false;
        }
        return id == ((Greeting) obj).id && Objects.equals(content, ((Greeting) obj).content);
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
