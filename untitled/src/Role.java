import java.time.LocalDateTime;

public class Role {
    private Integer rId;
    private String rName;
    private LocalDateTime inTime;

    public Integer getrId() {
        return rId;
    }

    public String getrName() {
        return rName;
    }

    public LocalDateTime getInTime() {
        return inTime;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public void setInTime(LocalDateTime inTime) {
        this.inTime = inTime;
    }
}
