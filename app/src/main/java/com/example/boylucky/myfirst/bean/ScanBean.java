package com.example.boylucky.myfirst.bean;

import java.util.List;

/**
 * Created by BoyLucky on 2018/7/11.
 */

public class ScanBean {


    private String msg;
    private String code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {

        private MiaoshaBean miaosha;
        private TuijianBean tuijian;
        private List<BannerBean> banner;
        private List<FenleiBean> fenlei;

        public MiaoshaBean getMiaosha() {
            return miaosha;
        }

        public void setMiaosha(MiaoshaBean miaosha) {
            this.miaosha = miaosha;
        }

        public TuijianBean getTuijian() {
            return tuijian;
        }

        public void setTuijian(TuijianBean tuijian) {
            this.tuijian = tuijian;
        }

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public List<FenleiBean> getFenlei() {
            return fenlei;
        }

        public void setFenlei(List<FenleiBean> fenlei) {
            this.fenlei = fenlei;
        }

        public static class MiaoshaBean {
            /**
             * list : [{"bargainPrice":99,"createtime":"2017-10-14T21:38:26","detailUrl":"https://item.m.jd.com/product/4345173.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t6037/35/2944615848/95178/6cd6cff0/594a3a10Na4ec7f39.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t6607/258/1025744923/75738/da120a2d/594a3a12Ne3e6bc56.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t6370/292/1057025420/64655/f87644e3/594a3a12N5b900606.jpg!q70.jpg","itemtype":1,"pid":45,"price":2999,"pscid":39,"salenum":4666,"sellerid":1,"subhead":"高清双摄，就是清晰！2000+1600万高清摄像头，6GB大内存+高通骁龙835处理器，性能怪兽！","title":"一加手机5 (A5000) 6GB+64GB 月岩灰 全网通 双卡双待 移动联通电信4G手机"},{"bargainPrice":6666,"createtime":"2017-10-10T16:01:31","detailUrl":"https://item.m.jd.com/product/5089273.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t8284/363/1326459580/71585/6d3e8013/59b857f2N6ca75622.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t9346/182/1406837243/282106/68af5b54/59b8480aNe8af7f5c.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8434/54/1359766007/56140/579509d9/59b85801Nfea207db.jpg!q70.jpg","itemtype":0,"pid":46,"price":234,"pscid":39,"salenum":868,"sellerid":2,"subhead":"【iPhone新品上市】新一代iPhone，让智能看起来更不一样","title":"Apple iPhone 8 Plus (A1864) 64GB 金色 移动联通电信4G手机"},{"bargainPrice":1599,"createtime":"2017-10-14T21:48:08","detailUrl":"https://item.m.jd.com/product/1993026402.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t5863/302/8961270302/97126/41feade1/5981c81cNc1b1fbef.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7003/250/1488538438/195825/53bf31ba/5981c57eN51e95176.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t5665/100/8954482513/43454/418611a9/5981c57eNd5fc97ba.jpg!q70.jpg","itemtype":2,"pid":47,"price":111,"pscid":39,"salenum":757,"sellerid":3,"subhead":"碳黑色 32GB 全网通 官方标配   1件","title":"锤子 坚果Pro 特别版 巧克力色 酒红色 全网通 移动联通电信4G手机 双卡双待 碳黑色 32GB 全网通"},{"bargainPrice":3455,"createtime":"2017-10-14T21:38:26","detailUrl":"https://item.m.jd.com/product/12224420750.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8461/5/1492479653/68388/7255e013/59ba5e84N91091843.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8461/5/1492479653/68388/7255e013/59ba5e84N91091843.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8803/356/1478945529/489755/2a163ace/59ba5e84N7bb9a666.jpg!q70.jpg","itemtype":1,"pid":48,"price":222,"pscid":39,"salenum":656,"sellerid":4,"subhead":"【现货新品抢购】全面屏2.0震撼来袭，骁龙835处理器，四曲面陶瓷机","title":"小米（MI） 小米MIX2 手机 黑色 全网通 (6GB+64GB)【标配版】"},{"bargainPrice":1999,"createtime":"2017-10-10T16:09:02","detailUrl":"https://item.m.jd.com/product/5025971.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t7210/232/3738666823/232298/9004583e/59c3a9a7N8de42e15.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8356/82/2107423621/109733/c019b8c6/59c3a9a6Ne9a4bdd7.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t10219/74/25356012/171379/7d55e296/59c3a9a8N82fa6e02.jpg!q70.jpg","itemtype":0,"pid":49,"price":333,"pscid":39,"salenum":123,"sellerid":5,"subhead":"vivo X20 带你开启全面屏时代！逆光也清晰，照亮你的美！","title":"vivo X20 全面屏手机 全网通 4GB+64GB 金色 移动联通电信4G手机 双卡双待"},{"bargainPrice":3455,"createtime":"2017-10-14T21:48:08","detailUrl":"https://item.m.jd.com/product/12224420750.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8461/5/1492479653/68388/7255e013/59ba5e84N91091843.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8461/5/1492479653/68388/7255e013/59ba5e84N91091843.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8803/356/1478945529/489755/2a163ace/59ba5e84N7bb9a666.jpg!q70.jpg","itemtype":2,"pid":50,"price":444,"pscid":39,"salenum":54,"sellerid":6,"subhead":"【现货新品抢购】全面屏2.0震撼来袭，骁龙835处理器，四曲面陶瓷机","title":"小米（MI） 小米MIX2 手机 黑色 全网通 (6GB+64GB)【标配版】"},{"bargainPrice":3455,"createtime":"2017-10-14T21:38:26","detailUrl":"https://item.m.jd.com/product/12224420750.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8461/5/1492479653/68388/7255e013/59ba5e84N91091843.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8461/5/1492479653/68388/7255e013/59ba5e84N91091843.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8803/356/1478945529/489755/2a163ace/59ba5e84N7bb9a666.jpg!q70.jpg","itemtype":1,"pid":51,"price":555,"pscid":39,"salenum":424,"sellerid":7,"subhead":"【现货新品抢购】全面屏2.0震撼来袭，骁龙835处理器，四曲面陶瓷机","title":"小米（MI） 小米MIX2 手机 黑色 全网通 (6GB+64GB)【标配版】"},{"bargainPrice":3455,"createtime":"2017-10-03T23:53:28","detailUrl":"https://item.m.jd.com/product/12224420750.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8461/5/1492479653/68388/7255e013/59ba5e84N91091843.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8461/5/1492479653/68388/7255e013/59ba5e84N91091843.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8803/356/1478945529/489755/2a163ace/59ba5e84N7bb9a666.jpg!q70.jpg","itemtype":0,"pid":52,"price":666,"pscid":39,"salenum":212,"sellerid":8,"subhead":"【现货新品抢购】全面屏2.0震撼来袭，骁龙835处理器，四曲面陶瓷机","title":"小米（MI） 小米MIX2 手机 黑色 全网通 (6GB+64GB)【标配版】"},{"bargainPrice":2999,"createtime":"2017-10-14T21:48:08","detailUrl":"https://item.m.jd.com/product/2385655.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t2068/298/2448145915/157953/7be197df/56d51a42Nd86f1c8e.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t2437/128/1687178395/117431/bcc190c1/56d3fcbaNb2963d21.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t2467/222/2263160610/95597/927b8a2f/56d3eafeNdecebeb6.jpg!q70.jpg","itemtype":2,"pid":53,"price":777,"pscid":39,"salenum":0,"sellerid":9,"subhead":"Super AMOLED三星双曲面2K 屏，支持无线充电！","title":"三星 Galaxy S7 edge（G9350）4GB+32GB 铂光金 移动联通电信4G手机 双卡双待"},{"bargainPrice":3455,"createtime":"2017-10-03T23:53:28","detailUrl":"https://item.m.jd.com/product/12224420750.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8461/5/1492479653/68388/7255e013/59ba5e84N91091843.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8461/5/1492479653/68388/7255e013/59ba5e84N91091843.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8803/356/1478945529/489755/2a163ace/59ba5e84N7bb9a666.jpg!q70.jpg","itemtype":0,"pid":54,"price":888,"pscid":39,"salenum":7575,"sellerid":10,"subhead":"【现货新品抢购】全面屏2.0震撼来袭，骁龙835处理器，四曲面陶瓷机","title":"小米（MI） 小米MIX2 手机 黑色 全网通 (6GB+64GB)【标配版】"},{"bargainPrice":3455,"createtime":"2017-10-14T21:38:26","detailUrl":"https://item.m.jd.com/product/12224420750.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8461/5/1492479653/68388/7255e013/59ba5e84N91091843.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8461/5/1492479653/68388/7255e013/59ba5e84N91091843.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8803/356/1478945529/489755/2a163ace/59ba5e84N7bb9a666.jpg!q70.jpg","itemtype":1,"pid":55,"price":5999,"pscid":39,"salenum":788,"sellerid":11,"subhead":"【现货新品抢购】全面屏2.0震撼来袭，骁龙835处理器，四曲面陶瓷机","title":"小米（MI） 小米MIX2 手机 黑色 全网通 (6GB+64GB)【标配版】"},{"bargainPrice":3455,"createtime":"2017-10-14T21:38:26","detailUrl":"https://item.m.jd.com/product/12224420750.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8461/5/1492479653/68388/7255e013/59ba5e84N91091843.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8461/5/1492479653/68388/7255e013/59ba5e84N91091843.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8803/356/1478945529/489755/2a163ace/59ba5e84N7bb9a666.jpg!q70.jpg","itemtype":1,"pid":56,"price":99,"pscid":39,"salenum":757,"sellerid":12,"subhead":"【现货新品抢购】全面屏2.0震撼来袭，骁龙835处理器，四曲面陶瓷机","title":"小米（MI） 小米MIX2 手机 黑色 全网通 (6GB+64GB)【标配版】"}]
             * name : 京东秒杀
             * time : 7200000
             */

            private String name;
            private int time;
            private List<ListBean> list;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getTime() {
                return time;
            }

            public void setTime(int time) {
                this.time = time;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * bargainPrice : 99
                 * createtime : 2017-10-14T21:38:26
                 * detailUrl : https://item.m.jd.com/product/4345173.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term=QQfriends
                 * images : https://m.360buyimg.com/n0/jfs/t6037/35/2944615848/95178/6cd6cff0/594a3a10Na4ec7f39.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t6607/258/1025744923/75738/da120a2d/594a3a12Ne3e6bc56.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t6370/292/1057025420/64655/f87644e3/594a3a12N5b900606.jpg!q70.jpg
                 * itemtype : 1
                 * pid : 45
                 * price : 2999
                 * pscid : 39
                 * salenum : 4666
                 * sellerid : 1
                 * subhead : 高清双摄，就是清晰！2000+1600万高清摄像头，6GB大内存+高通骁龙835处理器，性能怪兽！
                 * title : 一加手机5 (A5000) 6GB+64GB 月岩灰 全网通 双卡双待 移动联通电信4G手机
                 */

                private int bargainPrice;
                private String createtime;
                private String detailUrl;
                private String images;
                private int itemtype;
                private int pid;
                private int price;
                private int pscid;
                private int salenum;
                private int sellerid;
                private String subhead;
                private String title;

                public int getBargainPrice() {
                    return bargainPrice;
                }

                public void setBargainPrice(int bargainPrice) {
                    this.bargainPrice = bargainPrice;
                }

                public String getCreatetime() {
                    return createtime;
                }

                public void setCreatetime(String createtime) {
                    this.createtime = createtime;
                }

                public String getDetailUrl() {
                    return detailUrl;
                }

                public void setDetailUrl(String detailUrl) {
                    this.detailUrl = detailUrl;
                }

                public String getImages() {
                    return images;
                }

                public void setImages(String images) {
                    this.images = images;
                }

                public int getItemtype() {
                    return itemtype;
                }

                public void setItemtype(int itemtype) {
                    this.itemtype = itemtype;
                }

                public int getPid() {
                    return pid;
                }

                public void setPid(int pid) {
                    this.pid = pid;
                }

                public int getPrice() {
                    return price;
                }

                public void setPrice(int price) {
                    this.price = price;
                }

                public int getPscid() {
                    return pscid;
                }

                public void setPscid(int pscid) {
                    this.pscid = pscid;
                }

                public int getSalenum() {
                    return salenum;
                }

                public void setSalenum(int salenum) {
                    this.salenum = salenum;
                }

                public int getSellerid() {
                    return sellerid;
                }

                public void setSellerid(int sellerid) {
                    this.sellerid = sellerid;
                }

                public String getSubhead() {
                    return subhead;
                }

                public void setSubhead(String subhead) {
                    this.subhead = subhead;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }
        }

        public static class TuijianBean {

            private String name;
            private List<ListBeanX> list;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<ListBeanX> getList() {
                return list;
            }

            public void setList(List<ListBeanX> list) {
                this.list = list;
            }

            public static class ListBeanX {

                private int bargainPrice;
                private String createtime;
                private String detailUrl;
                private String images;
                private int itemtype;
                private int pid;
                private double price;
                private int pscid;
                private int salenum;
                private int sellerid;
                private String subhead;
                private String title;

                public void setPrice(double price) {
                    this.price = price;
                }

                public double getPrice() {

                    return price;
                }

                public int getBargainPrice() {
                    return bargainPrice;
                }

                public void setBargainPrice(int bargainPrice) {
                    this.bargainPrice = bargainPrice;
                }

                public String getCreatetime() {
                    return createtime;
                }

                public void setCreatetime(String createtime) {
                    this.createtime = createtime;
                }

                public String getDetailUrl() {
                    return detailUrl;
                }

                public void setDetailUrl(String detailUrl) {
                    this.detailUrl = detailUrl;
                }

                public String getImages() {
                    return images;
                }

                public void setImages(String images) {
                    this.images = images;
                }

                public int getItemtype() {
                    return itemtype;
                }

                public void setItemtype(int itemtype) {
                    this.itemtype = itemtype;
                }

                public int getPid() {
                    return pid;
                }

                public void setPid(int pid) {
                    this.pid = pid;
                }



                public int getPscid() {
                    return pscid;
                }

                public void setPscid(int pscid) {
                    this.pscid = pscid;
                }

                public int getSalenum() {
                    return salenum;
                }

                public void setSalenum(int salenum) {
                    this.salenum = salenum;
                }

                public int getSellerid() {
                    return sellerid;
                }

                public void setSellerid(int sellerid) {
                    this.sellerid = sellerid;
                }

                public String getSubhead() {
                    return subhead;
                }

                public void setSubhead(String subhead) {
                    this.subhead = subhead;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }
        }

        public static class BannerBean {

            private int aid;
            private String createtime;
            private String icon;
            private Object productId;
            private String title;
            private int type;
            private String url;

            public int getAid() {
                return aid;
            }

            public void setAid(int aid) {
                this.aid = aid;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public Object getProductId() {
                return productId;
            }

            public void setProductId(Object productId) {
                this.productId = productId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class FenleiBean {

            private int cid;
            private String createtime;
            private String icon;
            private int ishome;
            private String name;

            public int getCid() {
                return cid;
            }

            public void setCid(int cid) {
                this.cid = cid;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public int getIshome() {
                return ishome;
            }

            public void setIshome(int ishome) {
                this.ishome = ishome;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}