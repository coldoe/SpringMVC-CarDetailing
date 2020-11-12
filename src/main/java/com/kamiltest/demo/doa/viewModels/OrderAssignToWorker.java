package com.kamiltest.demo.doa.viewModels;

public class OrderAssignToWorker {
    private Long idOrder;
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
