package com.example.kdw.favorite.board;

import java.util.List;

/**
 * Created by kdw on 2015-12-06.
 */
public class Market {
    private int market_id;
    private String market_title;
    private String phone;
    private int grade;
    private int agree;
    private int business_id;
    private int area_id;
    private int place_id;
    private int user_id;

    private Business business;
    private Area area;
    private Place place;
    private List<Img> img;


    public int getMarket_id() {
        return market_id;
    }
    public void setMarket_id(int market_id) {
        this.market_id = market_id;
    }
    public String getMarket_title() {
        return market_title;
    }
    public void setMarket_title(String market_title) {
        this.market_title = market_title;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    public int getAgree() {
        return agree;
    }
    public void setAgree(int agree) {
        this.agree = agree;
    }
    public int getBusiness_id() {
        return business_id;
    }
    public void setBusiness_id(int business_id) {
        this.business_id = business_id;
    }
    public int getArea_id() {
        return area_id;
    }
    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }
    public int getPlace_id() {
        return place_id;
    }
    public void setPlace_id(int place_id) {
        this.place_id = place_id;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public Business getBusiness() {
        return business;
    }
    public void setBusiness(Business business) {
        this.business = business;
    }
    public Area getArea() {
        return area;
    }
    public void setArea(Area area) {
        this.area = area;
    }
    public Place getPlace() {
        return place;
    }
    public void setPlace(Place place) {
        this.place = place;
    }
    public List getImg() {
        return img;
    }
    public void setImg(List img) {
        this.img = img;
    }

}
