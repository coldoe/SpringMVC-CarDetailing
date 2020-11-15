package com.kamiltest.demo.doa.viewModels;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class OrderAssignToWorker {
    @Min(value = 1,message = "Required")
    @NotBlank(message = "You need to fill all fields, fields wont pass without values")
    @NotNull(message = "You need to fill all fields, fields wont pass without values")
    @NotEmpty(message = "You need to fill all fields, fields wont pass without values")
    private Long idOrder;

    @Min(value = 1,message = "Required")
    @NotBlank(message = "You need to fill all fields, fields wont pass without values")
    @NotNull(message = "You need to fill all fields, fields wont pass without values")
    @NotEmpty(message = "You need to fill all fields, fields wont pass without values")
    private Long idWorker;

    public OrderAssignToWorker() {
    }

    public OrderAssignToWorker(Long idOrder, Long idWorker) {
        this.idOrder = idOrder;
        this.idWorker = idWorker;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public Long getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(Long idWorker) {
        this.idWorker = idWorker;
    }

    @Override
    public String toString() {
        return "OrderAssignToWorker{" +
                "idOrder=" + idOrder +
                ", idWorker=" + idWorker +
                '}';
    }
}
