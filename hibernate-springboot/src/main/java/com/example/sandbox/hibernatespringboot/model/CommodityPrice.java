package com.example.sandbox.hibernatespringboot.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "commodity_prices")
public class CommodityPrice {

    @Id
    @Column( name = "id" )
    @GeneratedValue(generator = "com_pr_generator", strategy = GenerationType.SEQUENCE )
    @SequenceGenerator(name="com_pr_generator", sequenceName = "book_seq", allocationSize=50)
    private long id;

    @Column(name = "station_id")
    private int station_id;

    @Column(name = "commodity_id")
    private int commodity_id;

    @Column(name = "supply")
    private long supply;

    @Column(name = "buy_price")
    private int buy_price;

    @Column(name = "sell_price")
    private int sell_price;

    @Column(name = "demand")
    private long demand;

    @Column(name = "collected_at")
    private long collected_at;


    public CommodityPrice( int station_id, int commodity_id, long supply, int buy_price, int sell_price, long demand,
                           long collected_at ) {
        this.station_id = station_id;
        this.commodity_id = commodity_id;
        this.supply = supply;
        this.buy_price = buy_price;
        this.sell_price = sell_price;
        this.demand = demand;
        this.collected_at = collected_at;
    }
}
