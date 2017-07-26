package dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.github.ddth.dao.jdbc.IRowMapper;

import dao.Campaign;
import play.libs.Json;
import utils.IdUtils;

public class CampaignMapper implements IRowMapper<Campaign> {
	
	public final static CampaignMapper INSTANCE = new CampaignMapper();
	
	private final static String COL_ID = "cid";
	private final static String COL_CAMPAIGN_NAME = "c_campaign_name";
	private final static String COL_PAGE_TITLE = "c_page_title";
	private final static String COL_FROM_DATE = "c_from_date";
	private final static String COL_TO_DATE = "c_to_date";
	private final static String COL_DATA = "c_data";
	private final static String COL_CREATED_BY = "c_created_by";
	
	public final static String[] _COLS_ALL = { COL_ID, COL_CAMPAIGN_NAME, COL_PAGE_TITLE, COL_FROM_DATE, COL_TO_DATE, COL_DATA, COL_CREATED_BY};
	
	public final static String _CLAUSE_WHERE_KEY = COL_ID + " =? ";
	
	public final static String _VALUE_INSERT_CAMPAIGN = "?, ?, ?, ?, ?, ?, ?";
	
	public final static String _VALUE_UPDATE_CAMPAIGN = COL_CAMPAIGN_NAME + "= ?, " + COL_PAGE_TITLE + "= ?, "
			+ COL_FROM_DATE + "= ?, " + COL_TO_DATE + "= ?, " + COL_DATA + "= ? ";
	
	public static Object[] valueForSelect(String id) {
        return new Object[] { id };
    }
	
	public static Object[] valueForInsert(Campaign campaign) {
		return new Object[] { IdUtils.nextId(), campaign.getCampaignName(), campaign.getPageTitle(),
				campaign.getFromDate(), campaign.getToDate(), Json.toJson(convertData(campaign)).toString(), 0 };
	}
	
	public static Object[] valueForUpdate(String id, Campaign campaign) {
		return new Object[] {campaign.getCampaignName(), campaign.getPageTitle(),
				campaign.getFromDate(), campaign.getToDate(), Json.toJson(convertData(campaign)).toString(), id };
	}

	@Override
	public Campaign mapRow(ResultSet rs, int rowNum) throws SQLException {
		Campaign bo = new Campaign();
		bo.setId(rs.getString(COL_ID));
		bo.setCampaignName(rs.getString(COL_CAMPAIGN_NAME));
		bo.setPageTitle(rs.getString(COL_PAGE_TITLE));
		bo.setFromDate(rs.getString(COL_FROM_DATE));
		bo.setToDate(rs.getString(COL_TO_DATE));
		bo.setData(Json.toJson(rs.getString(COL_DATA)));
		bo.setCreatedBy(rs.getInt(COL_CREATED_BY));
		
		return bo;
	}
	
	public static Map<String, Map<String, Object>> convertData(Campaign campaign){
		Map<String, Map<String, Object>> data = new HashMap<>();
		Map<String, Object> content_q1 = new HashMap<>();
		campaign.getAnswer1().removeIf(Objects::isNull);
		
		content_q1.put("content", campaign.getQuestion1());
		content_q1.put("answer", campaign.getAnswer1());
		content_q1.put("type", campaign.getType());
		
		Map<String, Object> content_q2 = new HashMap<>();
		content_q2.put("content", campaign.getQuestion2());
		content_q2.put("answer", "");
		content_q2.put("type", 3);
		
		data.put("question_1", content_q1);
		data.put("question_2", content_q2);
		
		
		return data;
	}

}
