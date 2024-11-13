package org.example;

public class ObservableChannel implements IChannelAble {

    private String news;
    private String className;

    public ObservableChannel(String className) {
        this.className = className;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    @Override
    public void Update(String value) {
        System.out.println("This is The value of class "+ className+" : " + value);
    }
}
