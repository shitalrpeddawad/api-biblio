package org.compain.library.service.DTO;

import java.util.Date;

public class BorrowingDTO{
    private Long idBorrowing;
    private CopyDTO copyDto;
    private UserDTO userDto;
    private Date borrowingDate;
    private Boolean renawal;
    private Boolean returned;

    public Long getIdBorrowing() {
        return idBorrowing;
    }

    public void setIdBorrowing(Long idBorrowing) {
        this.idBorrowing = idBorrowing;
    }

    public CopyDTO getCopyDto() {
        return copyDto;
    }

    public void setCopyDto(CopyDTO copyDto) {
        this.copyDto = copyDto;
    }

    public UserDTO getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDTO userDto) {
        this.userDto = userDto;
    }

    public Date getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(Date borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public Boolean getRenawal() {
        return renawal;
    }

    public void setRenawal(Boolean renawal) {
        this.renawal = renawal;
    }

    public Boolean getReturned() {
        return returned;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }
}
