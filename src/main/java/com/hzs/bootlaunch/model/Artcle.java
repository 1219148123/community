package com.hzs.bootlaunch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
//alt+s
public class Artcle {

    /**
     * id : 0
     * title_hello : aaa
     * children : [{"id":9,"title_hello":"QA测试12","children":null},{"id":21,"title_hello":"鱿鱼","children":null}]
     */

    private int id;
    private String title_hello;
    private List<ChildrenBean> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle_hello() {
        return title_hello;
    }

    public void setTitle_hello(String title_hello) {
        this.title_hello = title_hello;
    }

    public List<ChildrenBean> getChildren() {
        return children;
    }

    public void setChildren(List<ChildrenBean> children) {
        this.children = children;
    }

    public static class ChildrenBean {
        /**
         * id : 9
         * title_hello : QA测试12
         * children : null
         */

        private int id;
        private String title_hello;
        private Object children;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle_hello() {
            return title_hello;
        }

        public void setTitle_hello(String title_hello) {
            this.title_hello = title_hello;
        }

        public Object getChildren() {
            return children;
        }

        public void setChildren(Object children) {
            this.children = children;
        }
    }
}
