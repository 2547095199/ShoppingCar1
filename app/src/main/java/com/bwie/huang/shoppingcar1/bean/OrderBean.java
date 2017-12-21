package com.bwie.huang.shoppingcar1.bean;

import java.util.List;

/**
 * Date:2017/12/20
 * time:19:43
 * author:HuangZhangpeng
 */
public class OrderBean {

    /**
     * msg : 请求成功
     * code : 0
     * data : [{"createtime":"2017-12-11T19:11:33","orderid":3344,"price":99.99,"status":0,"title":null,"uid":71},{"createtime":"2017-12-11T20:13:52","orderid":3345,"price":99.99,"status":0,"title":null,"uid":71},{"createtime":"2017-12-11T20:58:31","orderid":3346,"price":99.99,"status":0,"title":null,"uid":71},{"createtime":"2017-12-12T14:14:48","orderid":3349,"price":99.99,"status":0,"title":null,"uid":71},{"createtime":"2017-12-12T14:14:48","orderid":3350,"price":99.99,"status":0,"title":null,"uid":71},{"createtime":"2017-12-12T14:14:48","orderid":3351,"price":99.99,"status":0,"title":null,"uid":71},{"createtime":"2017-12-13T20:29:14","orderid":3371,"price":99.99,"status":0,"title":null,"uid":71},{"createtime":"2017-12-14T15:52:55","orderid":3376,"price":99.99,"status":0,"title":null,"uid":71},{"createtime":"2017-12-14T15:57:53","orderid":3377,"price":99.99,"status":0,"title":null,"uid":71},{"createtime":"2017-12-14T19:08:32","orderid":3410,"price":99.99,"status":0,"title":null,"uid":71}]
     * page : 1
     */

    private String msg;
    private String code;
    private String page;
    /**
     * createtime : 2017-12-11T19:11:33
     * orderid : 3344
     * price : 99.99
     * status : 0
     * title : null
     * uid : 71
     */

    private List<DataBean> data;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }

    public String getPage() {
        return page;
    }

    public List<DataBean> getData() {
        return data;
    }

    public static class DataBean {
        private String createtime;
        private int orderid;
        private double price;
        private int status;
        private Object title;
        private int uid;

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public void setOrderid(int orderid) {
            this.orderid = orderid;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public void setTitle(Object title) {
            this.title = title;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getCreatetime() {
            return createtime;
        }

        public int getOrderid() {
            return orderid;
        }

        public double getPrice() {
            return price;
        }

        public int getStatus() {
            return status;
        }

        public Object getTitle() {
            return title;
        }

        public int getUid() {
            return uid;
        }
    }
}
