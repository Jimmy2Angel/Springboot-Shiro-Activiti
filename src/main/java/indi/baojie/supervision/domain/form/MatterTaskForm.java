package indi.baojie.supervision.domain.form;

import indi.baojie.supervision.domain.MatterTask;

import java.util.List;

/**
 * Created by Lollipop on 2017/7/10.
 */
public class MatterTaskForm {

    private List<MatterTask> matterTasks;

    public List<MatterTask> getMatterTasks() {
        return matterTasks;
    }

    public void setMatterTasks(List<MatterTask> matterTasks) {
        this.matterTasks = matterTasks;
    }
}
