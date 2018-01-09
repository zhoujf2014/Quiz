package com.gtafe.quiz;

import java.util.List;

/**
 * Created by ZhouJF on 2018/1/6.
 */

public class QuestBean {

    /**
     * IsSucess : true
     * Msg : 成功
     * Data : {"eid":2,"list":[{"QuestionOptions":[{"ID":85,"QuestionId":21,"OptionName":"A","OptionContent":"计算机分解"},{"ID":86,"QuestionId":21,"OptionName":"B","OptionContent":"计算机分解"},{"ID":87,"QuestionId":21,"OptionName":"C","OptionContent":"计算机分解"},{"ID":88,"QuestionId":21,"OptionName":"D","OptionContent":"计算机分解"}],"QuestionOptionString":null,"ID":21,"QuestionType":2,"Stem":"计算机分解","AnswerKeys":"计算机分解","Score":0,"ArrangementId":2,"IsSelect":0,"DeleteType":0,"QuestionPId":0,"RightAnswer":"C,D","CreateBy":"d10a077c85ef4e57aa2a551112c3e303","CreateTime":"/Date(1515131043000)/","UpdateBy":"d10a077c85ef4e57aa2a551112c3e303","UpdateTime":"/Date(1515131043000)/"},{"QuestionOptions":[],"QuestionOptionString":null,"ID":22,"QuestionType":3,"Stem":"计算机分解计算机分解计算机分解计算机分解","AnswerKeys":"计算机分解计算机分解","Score":0,"ArrangementId":2,"IsSelect":0,"DeleteType":0,"QuestionPId":0,"RightAnswer":"Y","CreateBy":"d10a077c85ef4e57aa2a551112c3e303","CreateTime":"/Date(1515131105000)/","UpdateBy":"d10a077c85ef4e57aa2a551112c3e303","UpdateTime":"/Date(1515131105000)/"}]}
     */

    private boolean IsSucess;
    private String Msg;
    private DataBean Data;

    public boolean isIsSucess() {
        return IsSucess;
    }

    public void setIsSucess(boolean IsSucess) {
        this.IsSucess = IsSucess;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

    public DataBean getData() {
        return Data;
    }

    public void setData(DataBean Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * eid : 2
         * list : [{"QuestionOptions":[{"ID":85,"QuestionId":21,"OptionName":"A","OptionContent":"计算机分解"},{"ID":86,"QuestionId":21,"OptionName":"B","OptionContent":"计算机分解"},{"ID":87,"QuestionId":21,"OptionName":"C","OptionContent":"计算机分解"},{"ID":88,"QuestionId":21,"OptionName":"D","OptionContent":"计算机分解"}],"QuestionOptionString":null,"ID":21,"QuestionType":2,"Stem":"计算机分解","AnswerKeys":"计算机分解","Score":0,"ArrangementId":2,"IsSelect":0,"DeleteType":0,"QuestionPId":0,"RightAnswer":"C,D","CreateBy":"d10a077c85ef4e57aa2a551112c3e303","CreateTime":"/Date(1515131043000)/","UpdateBy":"d10a077c85ef4e57aa2a551112c3e303","UpdateTime":"/Date(1515131043000)/"},{"QuestionOptions":[],"QuestionOptionString":null,"ID":22,"QuestionType":3,"Stem":"计算机分解计算机分解计算机分解计算机分解","AnswerKeys":"计算机分解计算机分解","Score":0,"ArrangementId":2,"IsSelect":0,"DeleteType":0,"QuestionPId":0,"RightAnswer":"Y","CreateBy":"d10a077c85ef4e57aa2a551112c3e303","CreateTime":"/Date(1515131105000)/","UpdateBy":"d10a077c85ef4e57aa2a551112c3e303","UpdateTime":"/Date(1515131105000)/"}]
         */

        private int eid;
        private List<ListBean> list;

        public int getEid() {
            return eid;
        }

        public void setEid(int eid) {
            this.eid = eid;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * QuestionOptions : [{"ID":85,"QuestionId":21,"OptionName":"A","OptionContent":"计算机分解"},{"ID":86,"QuestionId":21,"OptionName":"B","OptionContent":"计算机分解"},{"ID":87,"QuestionId":21,"OptionName":"C","OptionContent":"计算机分解"},{"ID":88,"QuestionId":21,"OptionName":"D","OptionContent":"计算机分解"}]
             * QuestionOptionString : null
             * ID : 21
             * QuestionType : 2
             * Stem : 计算机分解
             * AnswerKeys : 计算机分解
             * Score : 0
             * ArrangementId : 2
             * IsSelect : 0
             * DeleteType : 0
             * QuestionPId : 0
             * RightAnswer : C,D
             * CreateBy : d10a077c85ef4e57aa2a551112c3e303
             * CreateTime : /Date(1515131043000)/
             * UpdateBy : d10a077c85ef4e57aa2a551112c3e303
             * UpdateTime : /Date(1515131043000)/
             */

            private Object QuestionOptionString;
            private int ID;
            private int QuestionType;
            private String Stem;
            private String AnswerKeys;
            private int Score;
            private int ArrangementId;
            private int IsSelect;
            private int DeleteType;
            private int QuestionPId;
            private String RightAnswer;
            private String CreateBy;
            private String CreateTime;
            private String UpdateBy;
            private String UpdateTime;
            private List<QuestionOptionsBean> QuestionOptions;

            public Object getQuestionOptionString() {
                return QuestionOptionString;
            }

            public void setQuestionOptionString(Object QuestionOptionString) {
                this.QuestionOptionString = QuestionOptionString;
            }

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }

            public int getQuestionType() {
                return QuestionType;
            }

            public void setQuestionType(int QuestionType) {
                this.QuestionType = QuestionType;
            }

            public String getStem() {
                return Stem;
            }

            public void setStem(String Stem) {
                this.Stem = Stem;
            }

            public String getAnswerKeys() {
                return AnswerKeys;
            }

            public void setAnswerKeys(String AnswerKeys) {
                this.AnswerKeys = AnswerKeys;
            }

            public int getScore() {
                return Score;
            }

            public void setScore(int Score) {
                this.Score = Score;
            }

            public int getArrangementId() {
                return ArrangementId;
            }

            public void setArrangementId(int ArrangementId) {
                this.ArrangementId = ArrangementId;
            }

            public int getIsSelect() {
                return IsSelect;
            }

            public void setIsSelect(int IsSelect) {
                this.IsSelect = IsSelect;
            }

            public int getDeleteType() {
                return DeleteType;
            }

            public void setDeleteType(int DeleteType) {
                this.DeleteType = DeleteType;
            }

            public int getQuestionPId() {
                return QuestionPId;
            }

            public void setQuestionPId(int QuestionPId) {
                this.QuestionPId = QuestionPId;
            }

            public String getRightAnswer() {
                return RightAnswer;
            }

            public void setRightAnswer(String RightAnswer) {
                this.RightAnswer = RightAnswer;
            }

            public String getCreateBy() {
                return CreateBy;
            }

            public void setCreateBy(String CreateBy) {
                this.CreateBy = CreateBy;
            }

            public String getCreateTime() {
                return CreateTime;
            }

            public void setCreateTime(String CreateTime) {
                this.CreateTime = CreateTime;
            }

            public String getUpdateBy() {
                return UpdateBy;
            }

            public void setUpdateBy(String UpdateBy) {
                this.UpdateBy = UpdateBy;
            }

            public String getUpdateTime() {
                return UpdateTime;
            }

            public void setUpdateTime(String UpdateTime) {
                this.UpdateTime = UpdateTime;
            }

            public List<QuestionOptionsBean> getQuestionOptions() {
                return QuestionOptions;
            }

            public void setQuestionOptions(List<QuestionOptionsBean> QuestionOptions) {
                this.QuestionOptions = QuestionOptions;
            }

            public static class QuestionOptionsBean {
                /**
                 * ID : 85
                 * QuestionId : 21
                 * OptionName : A
                 * OptionContent : 计算机分解
                 */

                private int ID;
                private int QuestionId;
                private String OptionName;
                private String OptionContent;

                public int getID() {
                    return ID;
                }

                public void setID(int ID) {
                    this.ID = ID;
                }

                public int getQuestionId() {
                    return QuestionId;
                }

                public void setQuestionId(int QuestionId) {
                    this.QuestionId = QuestionId;
                }

                public String getOptionName() {
                    return OptionName;
                }

                public void setOptionName(String OptionName) {
                    this.OptionName = OptionName;
                }

                public String getOptionContent() {
                    return OptionContent;
                }

                public void setOptionContent(String OptionContent) {
                    this.OptionContent = OptionContent;
                }
            }
        }
    }
}
