import ani.rss.entity.Ani;
import ani.rss.entity.Item;
import ani.rss.util.AniUtil;
import ani.rss.util.ConfigUtil;
import ani.rss.util.ItemsUtil;
import cn.hutool.core.lang.ConsoleTable;

import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        ConfigUtil.load();
        Ani ani = AniUtil.getAni("https://mikanime.tv/RSS/Bangumi?bangumiId=3394&subgroupid=370");
        System.out.println(ani);
        List<Item> items = ItemsUtil.getItems(ani);
        ConsoleTable consoleTable = new ConsoleTable();
        consoleTable.setSBCMode(false);
        consoleTable.addHeader("标题", "重命名");
        for (Item item : items) {
            String title = item.getTitle();
            String reName = item.getReName();
            consoleTable.addBody(title, reName);
        }
        consoleTable.print();
    }
}
