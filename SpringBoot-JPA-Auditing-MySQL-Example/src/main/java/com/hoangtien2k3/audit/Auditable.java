package com.hoangtien2k3.audit;

// Create Generic Auditable Class with Spring Data Annotations @CreatedBy, @CreatedDate, @LastModifiedBy, and @LastModifiedDate

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

// nó gần giống với abstract class
// lớp ánh xạ (mapped supperclass) không thể ánh xạ trực tiếp từ cơ sở dữ liệu,
// nhưng các lớp con có thể kế thừa và thực hiện kế thừa các thuộc tính và phương thức từ lớp ánh xạ
@MappedSuperclass
// Đây là một annotation được sử dụng để chỉ định rằng một entity sẽ lắng nghe (listen to) các sự kiện thay đổi và thực hiện các hành động liên quan.
// là một listener được sử dụng để theo dõi thay đổi của các entity liên quan đến thời gian tạo và thời gian cập nhật.
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {
    @CreatedBy // để đánh dấu trường trong đối tượng (entity) mà bạn muốn lưu thông tin về người tạo.
    protected U createBy;

    @CreatedDate //  thông tin về ngày và giờ cập nhật gần nhất của bản ghi.
    @Temporal(TemporalType.TIMESTAMP) // thời gian sẽ được lưu dưới dạng TIMESTAMP trong cơ sở dữ liệu
    protected Date createDate;

    @LastModifiedBy //  thông tin về người dùng đã thực hiện thay đổi gần nhất trên bản ghi.
    protected U lastModifiedBy;

    @LastModifiedDate //  trường đại diện cho ngày thực thể chứa trường được sửa đổi gần đây.
    protected Date lastMidifiedDate;

    public U getCreateBy() {
        return createBy;
    }

    public void setCreateBy(U createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public U getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(U lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastMidifiedDate() {
        return lastMidifiedDate;
    }

    public void setLastMidifiedDate(Date lastMidifiedDate) {
        this.lastMidifiedDate = lastMidifiedDate;
    }
}
