package indi.baojie.common.data;

/**
 * Created by Lollipop on 2017/7/31.
 */
public class TreeNode {

    /**
     * id
     */
    private  String id ;

    /**
     * 父级id
     */
    private  String pId;

    /**
     * 节点名称
     */
    private  String name;

    /**
     * 是否选择
     */
    private  Boolean checked;

    /**
     * 是否打开
     */
    private  Boolean open;

    public static class TreeNodeBuilder{
        private String id;

        private String pId;

        private String name;

        private Boolean checked;

        private Boolean open;

        public TreeNodeBuilder id(String id){
            this.id =id;
            return this;
        }

        public TreeNodeBuilder pId(String pId){
            this.pId =pId;
            return this;
        }

        public TreeNodeBuilder name(String name){
            this.name =name;
            return this;
        }

        public TreeNodeBuilder checked(Boolean checked){
            this.checked =checked;
            return this;
        }

        public TreeNodeBuilder open(Boolean open){
            this.open =open;
            return this;
        }

        public TreeNode builder(){
            return new TreeNode(this);
        }
    }



    private TreeNode(TreeNodeBuilder treeNodeBuilder){
        this.id = treeNodeBuilder.id;
        this.checked = treeNodeBuilder.checked;
        this.name = treeNodeBuilder.name;
        this.pId = treeNodeBuilder.pId;
        this.open = treeNodeBuilder.open;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id='" + id + '\'' +
                ", pId='" + pId + '\'' +
                ", name='" + name + '\'' +
                ", checked=" + checked +
                ", open=" + open +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getpId() {
        return pId;
    }

    public Boolean getChecked() {
        return checked;
    }

    public String getName() {
        return name;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }
}
