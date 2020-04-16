package com.company.view;

class Article {
    String name;
    int price;
    String description;
    String category;
    String articleLink;

    Article(String name, int price, String description, String category, String articleLink) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.articleLink = articleLink;
    }
}
