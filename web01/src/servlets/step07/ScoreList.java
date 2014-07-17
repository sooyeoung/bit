package servlets.step07;

import java.util.Map;

import org.apache.log4j.Logger;

// 출력을 JSP에게 위임하기

public class ScoreList implements PageController {
  static Logger logger = Logger.getLogger(ScoreList.class);
  ScoreDao scoreDao;
  
  public void setScoreDao(ScoreDao scoreDao) {
    this.scoreDao = scoreDao;
  }
  
  @Override
  public String execute(Map<String, String[]> params, Map<String, Object> model)
      throws Exception {
    logger.info("성적 목록 가져오기.....");
    int pageNo = 1, pageSize = 3;
    try {
      pageNo = Integer.parseInt(params.get("pageNo")[0]);
    } catch (Exception e) {}
    try {
      pageSize = Integer.parseInt(params.get("pageSize")[0]);
    } catch (Exception e) {}
    
    int countAll = scoreDao.countAll();
    int totalPage = countAll / pageSize;
    if ((countAll % pageSize) > 0) {
      totalPage++;
    }
    
    String order = null;
    if (params.get("order") != null) {
      order = params.get("order")[0];
      model.put("order", order);
    }
    
    model.put("scores", scoreDao.list(pageNo, pageSize, order));
    
    // 클라이언트로부터 정렬할 컬럼이름과 정렬 타입을 입력 받아 실행한다.
    /* 안전하지 않은 방법
    String columnName = params.get("columnName")[0];
    String orderType = params.get("orderType")[0];
    model.put("scores", scoreDao.list(pageNo, pageSize, columnName, orderType));
    */
    model.put("totalPage", totalPage);
    model.put("pageNo", pageNo);
    model.put("pageSize", pageSize);
    
    
    return "/score/step07/ScoreList.jsp";
  }

}










