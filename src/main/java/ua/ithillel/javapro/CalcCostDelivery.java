package ua.ithillel.javapro;
// Клас розрахунку вартості товару, враховуючи вартість доставки
public class CalcCostDelivery extends CalcCostBase{
    // Вартість доставки
    private final static double DELIVERY_PRICE = 7;

    // Розрахунок вартості товару, з урахуванням вартості доставки
    @Override
    public double calcCost(Product product) {
        return product.getQuota() * product.getPrice()
                + DELIVERY_PRICE;
    }
}

