package features;

import api.transaction.PostPromotionCal;
import model.request.transaction.DataCSV;
import model.request.transaction.TransactionItem;
import model.request.transaction.TransactionObject;
import model.response.transaction.PaymentObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.CsvHelper;

import java.util.Collections;

public class Demo1Test {

    PostPromotionCal promotionCal;

    @BeforeMethod
    public void setUp() {
        promotionCal = new PostPromotionCal();
    }

    @Test(dataProvider = "dataTest")
    public void testName(DataCSV obj) {
        TransactionItem item = new TransactionItem(obj.getQuantity(), obj.getUom_id());
        TransactionObject transaction = new TransactionObject()
                .setTransactionItems(Collections.singletonList(item))
                .setPromotionVouchers(Collections.emptyList())
                .setStoreId(obj.getStore_id())
                .setPaymentMethodId(1)
                .setOrderId("test");
        PaymentObject as = promotionCal.callAPI(transaction).as(PaymentObject.class);
    }

    @DataProvider
    public static Object[][] dataTest() {
        return CsvHelper.fileTo2DArray("data.csv", DataCSV.class);
    }

}
