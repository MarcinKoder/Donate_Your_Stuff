package pl.mwisniewski.Donate_Your_Stuff.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "donates")
public class Donate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @NotNull
    @Min(1)
    @Column(nullable = false)
    private Integer amount;

    private String types;

    @NotNull
    @ManyToOne
    private Charity charity;

    @Column
    private String city;
    @Column
    private String street;
    @Column
    private String postCode;
    @Column
    private String phone;
    @Column
    private String date;
    @Column
    private String hour;
    @Column
    private LocalDateTime dateOfPickup;

    @Column(name = "remarks")
    private String additionalRemarks;

    @Override
    public String toString() {
        return "Donate{" +
                "id=" + id +
                ", user=" + user +
                ", amount=" + amount +
                ", types='" + types + '\'' +
                ", charity=" + charity +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postCode='" + postCode + '\'' +
                ", phone='" + phone + '\'' +
                ", date='" + date + '\'' +
                ", hour='" + hour + '\'' +
                ", dateOfPickup=" + dateOfPickup +
                ", additionalRemarks='" + additionalRemarks + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donate donate = (Donate) o;
        return Objects.equals(id, donate.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public Charity getCharity() {
        return charity;
    }

    public void setCharity(Charity charity) {
        this.charity = charity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public LocalDateTime getDateOfPickup() {
        return dateOfPickup;
    }

    public void setDateOfPickup(LocalDateTime dateOfPickup) {
        this.dateOfPickup = dateOfPickup;
    }

    public String getAdditionalRemarks() {
        return additionalRemarks;
    }

    public void setAdditionalRemarks(String additionalRemarks) {
        this.additionalRemarks = additionalRemarks;
    }
}
