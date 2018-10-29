package com.anoyi.grpc.facade.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author: movie
 * @Date: 2018/10/29 10:46
 */
@Data
public class ExpandVo {


    /**
     * op : update
     * id : 299976
     * name : 传家本事
     * weburl : https://m.mgtv.com/h/299976.html?cxid=90f9ebg0u
     * appurl : imgotv://player?clipId=299976&plId=0&videoId=3551811&from=90f9ebg0u
     * alternative_names :
     * coverimage : http://3img.hitv.com/preview/internettv/sp_images/ott/2016/jishi/299976/20160913153710670-new.jpg
     * coverimage-x : http://1img.hitv.com/preview/internettv/sp_images/ott/2016/jishi/299976/20160913153715065-new.jpg
     * description : 传家本事四季微记录短片从中国人的四季生活着眼，给予四季不同的主题。每个季节12支记录短片，记录中国人讲究的生活、节日的礼仪、处事的哲学和生活的智慧。
     * tags : 传家本事 传家 人文 匠人 传统 中国 纪录片 本领
     * kind : 其他,文化,社会,自然
     * author :
     * create_time : 2016-09-13 15:34:51
     * modify_time : 2018-10-17 11:43:16
     * publish_time : 2016-09-13 00:00:00
     * releasedYear : 2016-09-13
     * isPay : 0
     * rating : 6
     * category : 纪录片
     * language : 普通话
     * play_count : 57859
     * play_length : 3376
     * episode_total_count : 13
     * episode_updated_count : 13
     * directors : 暂无
     * actors : 暂无
     * area : 内地
     */

    private String op;
    private String id;
    private String name;
    private String weburl;
    private String appurl;
    private String alternative_names;
    private String coverimage;
    @JSONField(name = "coverimage-x")
    private String coverimagex;
    private String description;
    private String tags;
    private String kind;
    private String author;
    private String create_time;
    private String modify_time;
    private String publish_time;
    private String releasedYear;
    private String isPay;
    private int rating;
    private String category;
    private String language;
    private long play_count;
    private int play_length;
    private String episode_total_count;
    private String episode_updated_count;
    private String directors;
    private String actors;
    private String area;
}
