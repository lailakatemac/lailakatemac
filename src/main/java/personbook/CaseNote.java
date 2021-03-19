package personbook;

import java.text.DateFormat;
import java.util.ArrayList;

public class CaseNote {
    private String dateTime;
    private String caseComment;

    public CaseNote(String dateTime, String caseComment) {
        this.dateTime = dateTime;
        this.caseComment = caseComment;
    }

    public String getDateTime() {
        return dateTime;
    }


    public String getCaseComment() {
        return caseComment;
    }

    public void setCaseComment(String caseComment) {
        this.caseComment = caseComment;
    }

    @Override
    public String toString() {
        return dateTime + "\n" + caseComment;
    }

}

