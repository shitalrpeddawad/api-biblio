package org.compain.library.service.DTO;

import org.compain.library.model.Copy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

public class LibraryDTO {

    private Long idLibrary;
    private String address;
    private String email;
    private String phone;
    private List<CopyDTO> copiesDTO;

    public Long getIdLibrary() {
        return idLibrary;
    }

    public void setIdLibrary(Long idLibrary) {
        this.idLibrary = idLibrary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<CopyDTO> getCopiesDTO() {
        return copiesDTO;
    }

    public void setCopiesDTO(List<CopyDTO> copiesDTO) {
        this.copiesDTO = copiesDTO;
    }
}
