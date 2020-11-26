package pipeline;

import entity.MedalBoard;
import entity.Material;

/**
 * description: 管道模式(pipeline)调用类
 * date: 11/23/20 14:15 PM
 * author: cjsmt
 */
public class PipelineDemo {
    public static void pipelineTest(){
        MedalBoard medalBoard = new MedalBoard();
        RankSort<MedalBoard, MedalBoard> rankSort = new RankSort<>(new GoldSort())
                .addSort(new SilverSort()).addSort(new BronzeSort());
        /**
         * 随意初始化奖牌榜
         */
        medalBoard.updateMedalBoard("Dog ", Material.Gold);
        medalBoard.updateMedalBoard("Dog ", Material.Gold);
        medalBoard.updateMedalBoard("Dog ", Material.Silver);
        medalBoard.updateMedalBoard("Dog ", Material.Bronze);
        medalBoard.updateMedalBoard("Chicken", Material.Gold);
        medalBoard.updateMedalBoard("Chicken", Material.Gold);
        medalBoard.updateMedalBoard("Chicken", Material.Gold);
        medalBoard.updateMedalBoard("Chicken", Material.Silver);
        medalBoard.updateMedalBoard("Bird", Material.Gold);
        medalBoard.updateMedalBoard("Bird", Material.Gold);
        medalBoard.updateMedalBoard("Bird", Material.Bronze);
        medalBoard.updateMedalBoard("Bear", Material.Silver);
        medalBoard.updateMedalBoard("Bear", Material.Bronze);
        medalBoard.updateMedalBoard("Bear", Material.Bronze);
        medalBoard.updateMedalBoard("Fish", Material.Silver);
        medalBoard.updateMedalBoard("Fish", Material.Bronze);
        medalBoard = rankSort.execute(medalBoard);
        medalBoard.showRank();

        /**
         * 测试设计模式
         * 添加奖牌，更新排名，展示检查榜 x 4
         */
        medalBoard.updateMedalBoard("Fish", Material.Silver);  //添加奖牌
        medalBoard = rankSort.execute(medalBoard);  //更新排名
        medalBoard.showRank();  //展示奖牌榜

        medalBoard.updateMedalBoard("Fish", Material.Silver);  //添加奖牌
        medalBoard = rankSort.execute(medalBoard);  //更新排名
        medalBoard.showRank();  //展示奖牌榜

        medalBoard.updateMedalBoard("Bear", Material.Gold);  //添加奖牌
        medalBoard = rankSort.execute(medalBoard);  //更新排名
        medalBoard.showRank();  //展示奖牌榜

        medalBoard.updateMedalBoard("Bear", Material.Gold);  //添加奖牌
        medalBoard = rankSort.execute(medalBoard);  //更新排名
        medalBoard.showRank();  //展示奖牌榜

    }
}
