package com.example.sandbox.hibernatespringboot.repo;

import com.example.sandbox.hibernatespringboot.model.CommodityPrice;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class CommodityPriceHandler {

    private static final Logger log = getLogger(CommodityPriceHandler.class);

    @Autowired
    CommodityPriceRepository commodityPriceRepository;

    @Autowired
    private EntityManager entityManager;

    public void inserIntoDB(int count, int batchSize) {

        int lineCount = 0;
        List<CommodityPrice> commodityPrices = new ArrayList<>();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();


        for (int i = 1; i <= count; ++i) {
            CommodityPrice commodityPrice = buildCommodityPrice(i*10);
            commodityPrices.add(commodityPrice);

            if (commodityPrices.size() == batchSize) {
                commodityPriceRepository.saveAll(commodityPrices);
                commodityPriceRepository.flush();
                entityManager.clear();
                commodityPrices.clear();
                System.out.println(lineCount);
            }

            lineCount++;
        }


        commodityPriceRepository.saveAll(commodityPrices);


        stopWatch.stop();

        log.info("Successfully inserted " + lineCount + " lines in " + stopWatch.getTotalTimeSeconds() + " seconds.");
    }

    private CommodityPrice buildCommodityPrice(int i) {
        int station_id = i;
        int commodity_id = i;
        long supply = i;
        int buy_price = i;
        int sell_price = i;
        long demand = i;
        long collected_at = i;

        return new CommodityPrice(station_id, commodity_id, supply, buy_price, sell_price, demand, collected_at);
    }
}
