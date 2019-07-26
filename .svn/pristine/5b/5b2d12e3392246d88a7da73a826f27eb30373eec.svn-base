package com.tce.content.service;

import java.net.URLEncoder;
import java.util.Optional;

import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tce.common.model.SystemConstants;
import com.tce.content.dao.TataBookContentRepository;
import com.tce.content.model.ContentBooksTata;
import com.tce.content.model.LessonConstants;

/**
 * @author jitendrar
 *
 */
@Service
public class ContentServiceImpl implements ContentService {

//	@Autowired
//	private ContentRepository contentRepository;
//
//	@Autowired
//	private ContentTpTataRepository contentTpTataRepository;

	@Autowired
	private TataBookContentRepository tataBookContentRepository;

//	@Autowired
//	private ContentAssetTataRepository contentAssetTataRepository;
//
//	@Autowired
//	private CurriculumLevelRepository curriculumLevelRepository;
//
//	@Autowired
//	private CurriculumSubjectRepository curriculumSubjectRepository;
//
//	@Autowired
//	private SchoolGradeRepository schoolGrdRepository;
//
//	@Autowired
//	private SchoolRepository schoolRepository;
//
//	@Autowired
//	private UserBookmarkRepository userBookmarkRepository;
//
//	@Autowired
//	private EncryptionKeysRepository encryptionKeysRepository;
//
//	@Autowired
//	private ContentQuestionDataRepository contentQuestionDataRepository;
//
//	@Autowired
//	private ContentQuestionTataRepository contentQuestionTataRepository;
//
//	@Autowired
//	private ContentActivityMapRepository contentActivityMapRepository;
//
//	@Autowired
//	private ContentUtil contentUtil;
	

	private static final Logger logger = LoggerFactory.getLogger(ContentServiceImpl.class);

//	@Override
//	@Transactional(readOnly = true)
//	public CurriculumResponse gradeAndSubjectList(String orgId) {
//		CurriculumResponse curriculumResponse = null;		
//		Map<String, String> gradeSchoolGrdMap = new HashMap<>();
//		Map<String, String> gradeOrderMap = new HashMap<>();
//		List<CurriculumBook> grdCurriculumList = null;
//		Map<String, String> gradeTitleMap = new HashMap<>();
//		try {
//			// get the school grade details from ayp and school grade tables
//			Map<String, List<SchoolGradeDivisions>> schoolGradeDivisions = getSchoolGradeDivisions(
//					schoolGrdRepository.findGradeBySchoolId(orgId.trim(), 1), gradeSchoolGrdMap, gradeOrderMap,
//					gradeTitleMap);
//
//			// get only school grades
//			// Getting Set of keys from HashMap
//			Set<String> keySet = schoolGradeDivisions.keySet();
//			// Creating an ArrayList of keys by passing the keySet
//			ArrayList<String> listOfGrds = new ArrayList<>(keySet);
//
//			// get curId
//			String curId = schoolRepository.findBySchoolId(orgId);
//			if (null != curId) {
//				grdCurriculumList = contentRepository.getGrdCurriculum(curId, listOfGrds);
//			}
//			if(null != grdCurriculumList && !grdCurriculumList.isEmpty()) {
//				// Retrieve subject and book details for each gradeId
//				Map<String, List<SubjectBooks>> grdSubjectBooks = getSubjectBooks(grdCurriculumList);
//				// get grade Details
//				List<GradeResponse> gradeBeanList = getGradeDetails(grdCurriculumList, gradeSchoolGrdMap, gradeOrderMap,
//						grdSubjectBooks, schoolGradeDivisions, gradeTitleMap);
//
//				// get the level details from curriculum book
//				List<LevelResponse> levelBeanList = null;
//				List<CurriculumBook> levCurriculumList = contentRepository.levCurriculumByOrgId(orgId);
//				if(null != levCurriculumList && !levCurriculumList.isEmpty()) {
//					// Retrieve subject and book details for each levId
//					Map<String, List<SubjectBooks>> levSubjectBooks = getSubjectBooks(levCurriculumList);
//					levelBeanList = getLevelList(levCurriculumList, levSubjectBooks);
//				}
//
//				// get Encryption keys iv and jws
//				EncryptionKeys sessionKeys = encryptionKeysRepository.getEncryptionKeys();
//
//				// complete the response
//				curriculumResponse = new CurriculumResponse(grdCurriculumList.get(0).getCurriculumId(), gradeBeanList,
//						levelBeanList, sessionKeys);
//			
//			}			
//		} catch (Exception ex) {
//			logger.error("Exception in getCurriculum :", ex);
//		}
//		return curriculumResponse;
//	}
//
//	private List<LevelResponse> getLevelList(List<CurriculumBook> levCurriculumList,
//			Map<String, List<SubjectBooks>> levSubjectBooks) {
//		List<String> gradeList = new ArrayList<>();
//		List<LevelResponse> levelBeanList = new ArrayList<>();
//		for (CurriculumBook curriculumBook : levCurriculumList) {
//			String levelId = curriculumBook.getLevelId();
//			if (levelId != null && !gradeList.contains(levelId)) {
//				Optional<CurriculumLevel> clevelValue = curriculumLevelRepository.findById(levelId);
//				if (clevelValue.isPresent()) {
//					CurriculumLevel clevels = clevelValue.get();
//					LevelResponse lb = new LevelResponse(clevels.getLevelId(), clevels.getTitle(),
//							levSubjectBooks.get(levelId));
//					gradeList.add(levelId);
//					levelBeanList.add(lb);
//				}
//			}
//		}
//		return levelBeanList;
//	}
//
//	private List<GradeResponse> getGradeDetails(List<CurriculumBook> grdCurriculumList,
//			Map<String, String> gradeSchoolGrdMap, Map<String, String> gradeOrderMap,
//			Map<String, List<SubjectBooks>> grdSubjectBooks,
//			Map<String, List<SchoolGradeDivisions>> schoolGradeDivisions,Map<String, String> gradeTitleMap) {
//		List<String> gradeList = new ArrayList<>();
//		List<GradeResponse> gradeBeanList = new ArrayList<>();
//		for (CurriculumBook curriculumBook : grdCurriculumList) {
//			String levelId = curriculumBook.getLevelId();
//			if (levelId != null && !gradeList.contains(levelId)) {
//							GradeResponse gb = new GradeResponse(levelId,gradeTitleMap.get(levelId) ,
//							gradeSchoolGrdMap.get(levelId), gradeOrderMap.get(levelId), grdSubjectBooks.get(levelId),
//							schoolGradeDivisions.get(levelId));
//					gradeList.add(levelId);
//					gradeBeanList.add(gb);				
//			}
//		}
//		return gradeBeanList;
//	}
//
//	public Map<String, List<SchoolGradeDivisions>> getSchoolGradeDivisions(List<Object[]> objList,
//			Map<String, String> gradeSchoolGrdMap, Map<String, String> gradeOrderMap,
//			Map<String, String> gradeTitleMap) {
//		Map<String, List<SchoolGradeDivisions>> schoolGradeDivisions = new HashMap<>();
//		for (Object[] obj : objList) {
//			String classedgegradeid = obj[0].toString();
//			String schoolgradeid = obj[1].toString();
//			String orderNo = obj[2].toString();
//			String gradeTitle = "";
//			if (obj[3] != null)
//				gradeTitle = obj[3].toString();
//			String divisionTitle = "";
//			if (obj[4] != null)
//				divisionTitle = obj[4].toString();
//			SchoolGradeDivisions divisions = new SchoolGradeDivisions(gradeTitle, divisionTitle);
//			if (schoolGradeDivisions.containsKey(classedgegradeid)) {
//				schoolGradeDivisions.get(classedgegradeid).add(divisions);
//			} else {
//				List<SchoolGradeDivisions> divisionList = new ArrayList<>();
//				divisionList.add(divisions);
//				schoolGradeDivisions.put(classedgegradeid, divisionList);
//			}
//
//			if (!gradeSchoolGrdMap.containsKey(classedgegradeid)) {
//				gradeOrderMap.put(classedgegradeid, orderNo);
//				gradeSchoolGrdMap.put(classedgegradeid, schoolgradeid);
//				gradeTitleMap.put(classedgegradeid, gradeTitle);
//			}
//		}
//		return schoolGradeDivisions;
//	}
//
//	public Map<String, List<SubjectBooks>> getSubjectBooks(List<CurriculumBook> curriculumList) {
//		Map<String, List<SubjectBooks>> subBooks = new HashMap<>();
//		for (CurriculumBook curriculumBook : curriculumList) {
//			String levelId = curriculumBook.getLevelId();
//			String subId = curriculumBook.getSubjectId();
//
//			Optional<ContentBooksTata> contentBooksTataVal = tataBookContentRepository
//					.findById(curriculumBook.getBookId());
//			if (contentBooksTataVal.isPresent()) {
//				ContentBooksTata contentBooksTata = contentBooksTataVal.get();
//				BookDetails bookDetails = new BookDetails(curriculumBook.getBookId(), contentBooksTata.getTitle());
//				Optional<CurriculumSubject> subjectVal = curriculumSubjectRepository.findById(subId);
//				if (subjectVal.isPresent()) {
//					CurriculumSubject subject = subjectVal.get();
//					SubjectBooks subjectBooks = new SubjectBooks(subject.getSubjectId(), subject.getTitle(),
//							subject.getStatus(), subject.getMapping(), subject.getHasGames(), bookDetails);
//					if (!subBooks.containsKey(levelId)) {
//						List<SubjectBooks> subjectBookList = new ArrayList<>();
//						subjectBookList.add(subjectBooks);
//						subBooks.put(levelId, subjectBookList);
//
//					} else {
//						subBooks.get(levelId).add(subjectBooks);
//					}
//				}
//			}
//		}
//		return subBooks;
//	}
//
//	@Override
//	@Transactional(readOnly = true)
//	public List<PlaylistResponse> getVTPAssets(List<String> assetIds) {
//		ContentAssetTataResponse assetResponse = null;
//		List<PlaylistResponse> playResponseList = null;
//		try {
//			assetResponse = getAssetDetails(assetIds);
//			if (assetResponse != null) {
//				PlaylistJson playList = new PlaylistJson();
//				playList.setCreationDate(new Date());
//				playList.setEncryptedFilePath(assetResponse.getEncryptedFilePath());
//				playList.setAsset(assetResponse.getAsset());
//				// getting upload relative filepath as for all assets there will be only one tp
//				Optional<ContentAssetTata> assetContentValue = contentAssetTataRepository.findById(assetIds.get(0));
//				if (assetContentValue.isPresent()) {
//					ContentAssetTata assetContent = assetContentValue.get();
//					String filePath = contentUtil.getBasePath(assetContent.getTpId()) + assetContent.getLcmsGradeId()
//							+ Constants.FILE_SEPARATOR + assetContent.getLcmsSubjectId() + Constants.FILE_SEPARATOR
//							+ assetContent.getTpId();
//					// get the practice details
//					List<String> questionIds = getPracticeDetails(assetContent.getTpId());
//					if (null != questionIds && !questionIds.isEmpty()) {
//						playList.setPractice(questionIds);
//					}
//					// convert json to string
//					String playlistFile = contentUtil.convertObjectToJson(playList);
//
//					// upload json to filepath
//					String playListJsonRes = contentUtil.uploadFile(playlistFile, filePath,
//							Constants.PLAYLIST_JSON);
//					if (playListJsonRes != null) {
//						playResponseList = new ArrayList<>();
//						PlaylistResponse play = new PlaylistResponse();
//						play.setPlaylistJson(playListJsonRes);
//						playResponseList.add(play);
//						return playResponseList;
//					}
//				}
//			}
//		} catch (Exception ex) {
//			logger.error("Error during fetch Asset Content : ", ex);
//		}
//		return playResponseList;
//
//	}
//
//	@Override
//	@Transactional(readOnly = true)
//	public List<PlaylistResponse> getTopicAssetDetails(List<String> tpIds) {		
//		List<PlaylistResponse> response = new ArrayList<>();		
//		try {
//			List<ContentTpTata> contentTpTataList = contentTpTataRepository.findAllById(tpIds);
//			for (ContentTpTata contentTpTata : contentTpTataList) {
//				response = getPlaylistDetails(contentTpTata);
//				}
//		} catch (Exception ex) {
//			logger.debug("Error during fetch Asset Content {}", ex.getMessage());
//		}
//		return response;
//	}
//
//	private List<PlaylistResponse> getPlaylistDetails(ContentTpTata contentTpTata) {		
//		List<PlaylistResponse> response = new ArrayList<>();
//		List<Activity> activityList = null;
//		ContentAssetTataResponse assetDetails = null;
//		activityList = new ArrayList<>();
//		String tceseq = contentUtil.getBasePath(contentTpTata.getTpId()) + contentTpTata.getLcmsGradeId()
//				+ Constants.FILE_SEPARATOR + contentTpTata.getLcmsSubjectId() + Constants.FILE_SEPARATOR
//				+ contentTpTata.getTpId() + Constants.FILE_SEPARATOR + Constants.TCESEQ_JSON;
//
//		String tcejson = contentUtil.getFileFromPath(tceseq);
//		if (null != tcejson) {
//			TceSeqBean tceSeqBean = getTceSeqBean(tcejson);
//			if (null != tceSeqBean) {
//				String enPath = null;
//				for (ActivityBean actBean : tceSeqBean.getActivityBean()) {
//					List<String> assetIds = contentActivityMapRepository
//							.findByActivityId(actBean.getActivityId());
//					assetDetails = getAssetDetails(assetIds);
//					if (assetDetails != null) {
//						enPath = assetDetails.getEncryptedFilePath();
//						Activity activity = new Activity();
//						activity.setActivityId(actBean.getActivityId());
//						activity.setOrderNo(actBean.getOrderNo());
//						activity.setAsset(assetDetails.getAsset());
//						activityList.add(activity);
//					}
//				}
//				if (!activityList.isEmpty()) {
//					String filePath = contentUtil.getBasePath(contentTpTata.getTpId())
//							+ contentTpTata.getLcmsGradeId() + Constants.FILE_SEPARATOR
//							+ contentTpTata.getLcmsSubjectId() + Constants.FILE_SEPARATOR
//							+ contentTpTata.getTpId() + Constants.FILE_SEPARATOR;
//
//					response = getPlayList(activityList, enPath, filePath, contentTpTata.getTpId());
//					
//				}
//			}
//		}
//		return response;
//	}
//
//	private List<PlaylistResponse> getPlayList(List<Activity> activityList, String enPath, String filePath,
//			String tpId) {
//		List<PlaylistResponse> response = new ArrayList<>();
//		Collections.sort(activityList, new Activity.SortbyOrder());
//		PlaylistJson playList = new PlaylistJson();
//		playList.setCreationDate(new Date());
//		playList.setEncryptedFilePath(enPath);
//		for (Activity activity : activityList) {
//			playList.getAsset().addAll(activity.getAsset());
//		}
//
//		// get the practice details
//		List<String> questionIds = getPracticeDetails(tpId);
//		if (null != questionIds && !questionIds.isEmpty()) {
//			playList.setPractice(questionIds);
//		}
//
//		// convert json to string
//		String playlistFile = contentUtil.convertObjectToJson(playList);
//
//		String playListJsonRes = contentUtil.uploadFile(playlistFile, filePath,
//				Constants.PLAYLIST_JSON);
//		if (playListJsonRes != null) {
//			PlaylistResponse play = new PlaylistResponse();
//			play.setId(tpId);
//			play.setPlaylistJson(playListJsonRes);
//			response.add(play);
//		}
//		return response;
//	}
//
//	// get the questionList
//	private List<String> getPracticeDetails(String tpId) {
//		return contentQuestionTataRepository.findBytpId(tpId);
//	}
//
//	private TceSeqBean getTceSeqBean(String tcejson) {
//		TceSeqBean tceSeqBean = null;
//		try {
//			JSONObject jsonObject = new JSONObject(tcejson);
//			if (jsonObject.has("presentation")) {
//				JSONArray activity = (JSONArray) jsonObject.get("presentation");
//				for (Object each : activity) {
//					tceSeqBean = new TceSeqBean();
//					List<ActivityBean> actList = new ArrayList<>();
//					JSONObject activityObj = (JSONObject) each;
//					tceSeqBean.setName(activityObj.get("name").toString());
//					tceSeqBean.setDuration(activityObj.get("duration").toString());
//					JSONArray activityList = (JSONArray) activityObj.get("sequenceVo");
//					for (Object activityDet : activityList) {
//						ActivityBean ac = new ActivityBean();
//						JSONObject jsonobject = (JSONObject) activityDet;
//						ac.setActivityId(jsonobject.get("activityId").toString());
//						ac.setOrderNo(jsonobject.get("orderNo").toString());
//						actList.add(ac);
//					}
//					tceSeqBean.setActivityBean(actList);
//				}
//			}
//		} catch (Exception ex) {
//			logger.error("Error during fetch Asset Content {} ", ex);
//		}
//		return tceSeqBean;
//	}
//
//	private ContentAssetTataResponse getAssetDetails(List<String> assetIds) {
//		ContentAssetTataResponse response = new ContentAssetTataResponse();
//		String assetPath = "";
//		try {
//			List<ContentAssetTata> assetContentList = contentAssetTataRepository.findAllById(assetIds);
//			if (!assetContentList.isEmpty()) {
//				for (ContentAssetTata contentAssetTata : assetContentList) {
//
//					assetPath = Constants.ASSET_BASE_PATH + contentAssetTata.getLcmsGradeId() + Constants.FILE_SEPARATOR
//							+ contentAssetTata.getLcmsSubjectId();
//					ContentAssetTataResponse.ContentAsset asset = new ContentAssetTataResponse.ContentAsset(
//							contentAssetTata.getAssetId(), contentAssetTata.getTitle(), contentAssetTata.getMimeType(),
//							contentAssetTata.getAssetType(), contentAssetTata.getThumbFileName(),
//							contentAssetTata.getLcmsSubjectId(), contentAssetTata.getFileName(),
//							contentAssetTata.getAnsKeyId(), contentAssetTata.getSubType(),
//							contentAssetTata.getDescription());
//					response.getAsset().add(asset);
//				}
//				if (!response.getAsset().isEmpty()) {
//					String encryptFileName = URLEncoder.encode(assetPath, "UTF-8");
//					response.setEncryptedFilePath(encryptFileName);
//					return response;
//				}
//			}
//		} catch (Exception ex) {
//			logger.error("Error during fetch Asset Content {} ", ex);
//		}
//		return null;
//
//	}
//
	@Override
	@Transactional(readOnly = true)
	public ContentBooksTata getBooks(String bookId) {
		ContentBooksTata content = null;
		try {
			// get the book details from content_books_tata table
			Optional<ContentBooksTata> contentValue = tataBookContentRepository.findById(bookId);
			if (contentValue.isPresent()) {
				return contentValue.get();
			}
		} catch (Exception ex) {
			logger.error("Error during fetch Book Content : ", ex);
		}
		return content;
	}

	@Override
	@Transactional(readOnly = false)
	public String getEBookPath(ContentBooksTata content) {
		if (content.isHasEbook()) {
			try {
				return URLEncoder.encode(LessonConstants.EBOOK_BASE_PATH, SystemConstants.CHAR_SET);
			} catch (Exception ex) {
				logger.error("Error during fetch eBook Path : ", ex);
			}
		}
		return null;
	}

	@Override
	@Transactional(readOnly=false)
	public ContentBooksTata getBookJson(ContentBooksTata content) throws Exception{
		
		JSONObject xmlJSONObj = XML.toJSONObject(content.getXml());	        
		String jsonString = xmlJSONObj.toString();
		content.setBookJson(jsonString);
		content.setBookStatus(true);
		tataBookContentRepository.save(content);
		return content;
	}

//	@Override
//	@Transactional(readOnly = true)
//	public RecentViewResponse getRecentViews(String userId, String organizationId) {
//		RecentViewResponse recentViewResponse = null;
//		try {
//			UserBookmarkEmbeddable userBookmarkEmbeddable = new UserBookmarkEmbeddable(userId, Constants.RECENT_VIEW);
//
//			// get Encryption keys iv and jws
//			EncryptionKeys sessionKeys = encryptionKeysRepository.getEncryptionKeys();
//
//			UserBookmark userBookmark = userBookmarkRepository
//					.findByUserBookmarkEmbeddableAndOrganizationId(userBookmarkEmbeddable, organizationId);
//			if (userBookmark != null) {
//				recentViewResponse = new RecentViewResponse(userBookmark.getData(),
//						userBookmark.getUserBookmarkEmbeddable().getUserId(),
//						userBookmark.getUserBookmarkEmbeddable().getType(), userBookmark.getOrganizationId(),
//						sessionKeys);
//			} else {
//				recentViewResponse = new RecentViewResponse();
//				recentViewResponse.setData("");
//				recentViewResponse.setSessionKeys(sessionKeys);
//			}
//		} catch (Exception ex) {
//			logger.error("Error during get recent view list:", ex);
//		}
//		return recentViewResponse;
//	}
//
//	@Override
//	@Transactional
//	public UserBookmark saveOrUpdateRecentViews(String organizationId, String userId,
//			UserBookmarkRequest userBookmarkRequest, boolean isUpdate) {
//		UserBookmark userBookmark = null;
//			UserBookmarkEmbeddable userBookmarkEmbeddable = new UserBookmarkEmbeddable(userId, Constants.RECENT_TYPE);
//			// isUpdate flag is true when is a update call
//			if (isUpdate) {
//				userBookmark = userBookmarkRepository
//						.findByUserBookmarkEmbeddableAndOrganizationId(userBookmarkEmbeddable, organizationId);
//				if (userBookmark != null) {
//					userBookmark.setData(userBookmarkRequest.getData());
//					userBookmark.setLastUpdatedOn(new Date());
//					return userBookmarkRepository.save(userBookmark);
//				}
//			} else {
//				userBookmark = new UserBookmark(organizationId, userBookmarkEmbeddable, userBookmarkRequest.getData(),
//						new Date());
//				return userBookmarkRepository.save(userBookmark);
//			}
//		return userBookmark;
//	}
//
//	@Override
//	@Transactional(readOnly = true)
//	public List<ContentQuestionData> getQuestionContents(List<String> questIds) {
//		List<ContentQuestionData> questionList = null;
//		try {
//			questionList = contentQuestionDataRepository.findAllById(questIds);
//		} catch (Exception ex) {
//			logger.error("Error inside getQuestionContents :" , ex);
//		}
//		return questionList;
//	}
//
//	private String getEncryptedQuesPath(ContentQuestionTata contentQuestionTata) {
//		try {
//			String tpId = contentQuestionTata.getTpId();
//			// prepare encrypted path
//			String actualPath = contentUtil.getBasePath(tpId) + contentQuestionTata.getLcmsGradeId()
//					+ Constants.FILE_SEPARATOR + contentQuestionTata.getLcmsSubjectId() + Constants.FILE_SEPARATOR
//					+ tpId + Constants.FILE_SEPARATOR + Constants.INTERNAL_QUIZ;
//
//			return URLEncoder.encode(actualPath, Constants.CHAR_SET);
//		} catch (UnsupportedEncodingException ue) {
//			logger.error("Error inside getEncryptedQuesPath :", ue);
//		} catch (Exception ex) {
//			logger.error("Error inside getEncryptedQuesPath :" , ex);
//		}
//		return null;
//
//	}
//
//	@Override
//	@Transactional
//	public QuestionJson saveQuestionXmlToJson(ContentQuestionData contentQuestionData) {
//		String qJson = null;
//		QuestionJson questionContentResponse = null;
//		try {
//			// get questionJson if not exists
//			qJson = contentUtil.convertXmlToJson(contentQuestionData.getXml());
//			contentQuestionData.setqJson(new String(qJson.getBytes(), StandardCharsets.UTF_8));
//			contentQuestionData.setqStatus(true);
//			contentQuestionData = contentQuestionDataRepository.save(contentQuestionData);
//			questionContentResponse = new QuestionJson(contentQuestionData.getQuestionId(),
//					contentQuestionData.getqJson());			
//		}  catch (Exception ex) {
//			logger.error("Error inside saveQuestionXmlToJson :" , ex);
//		}
//		return questionContentResponse;
//	}
//
//	@Override
//	@Transactional(readOnly = true)
//	public String getQuestionPath(String questionId) {
//		Optional<ContentQuestionTata> contentQuestionTataVal = contentQuestionTataRepository.findById(questionId);
//		if(contentQuestionTataVal.isPresent()) {
//			ContentQuestionTata contentQuestionTata = contentQuestionTataVal.get();		
//			return getEncryptedQuesPath(contentQuestionTata);
//		}
//		return null;
//	}
//
//	@Override
//	@Transactional(readOnly = true)
//	public ContentTpTata getLPBytpId(String tpId) {
//		return contentTpTataRepository.getLessonPlanByTpId(tpId);
//	}
//
//	@Override
//	@Transactional(readOnly = true)
//	public ContentTpTataXMLDetails getLpJson(ContentTpTata contentTpTata) {
//		ContentTpTataXMLDetails contentTpTataXMLDetails = null;
//		String topicJson = null;
//		try {
//			// created topic folder path by ids
//			String tpPath = contentUtil.getBasePath(contentTpTata.getTpId()) + contentTpTata.getLcmsGradeId()
//					+ Constants.FILE_SEPARATOR + contentTpTata.getLcmsSubjectId() + Constants.FILE_SEPARATOR
//					+ contentTpTata.getTpId();
//			String tpJsonFilePath = tpPath + Constants.FILE_SEPARATOR + Constants.TOPIC_JSON;
//
//			topicJson = contentUtil.getFileFromPath(tpJsonFilePath);
//			contentTpTataXMLDetails = new ContentTpTataXMLDetails(URLEncoder.encode(tpPath, Constants.CHAR_SET),
//					topicJson);
//
//		} catch (Exception ex) {
//			logger.error("Error inside getLpJson :" , ex);
//		}
//		return contentTpTataXMLDetails;
//	}
//
//	@Override
//	@Transactional
//	public ContentTpTataXMLDetails getLpJsonXml(ContentTpTata contentTpTata) {
//		String topicJson = null;
//		ContentTpTataXMLDetails contentTpTataXMLDetails = null;
//		try {
//			// created topic folder path by ids
//			String tpPath = contentUtil.getBasePath(contentTpTata.getTpId()) + contentTpTata.getLcmsGradeId()
//					+ Constants.FILE_SEPARATOR + contentTpTata.getLcmsSubjectId() + Constants.FILE_SEPARATOR
//					+ contentTpTata.getTpId();
//			String tpXmlFilePath = tpPath + Constants.FILE_SEPARATOR + Constants.TOPIC_XML;
//			String tpXml = contentUtil.getFileFromPath(tpXmlFilePath);
//			if (null != tpXml)
//				topicJson = contentUtil.convertXmlToJson(tpXml);
//			// save json after creation and update the status
//			String playListJsonRes = contentUtil.uploadFile(topicJson, tpPath, Constants.TOPIC_JSON);
//			if (null != playListJsonRes) {
//				saveTpJsonStatus(contentTpTata);
//				contentTpTataXMLDetails = new ContentTpTataXMLDetails(URLEncoder.encode(tpPath, Constants.CHAR_SET),
//						playListJsonRes);
//			}
//		} catch (Exception ex) {
//			logger.error("Error inside getLpJsonXml :" , ex);
//		}
//		return contentTpTataXMLDetails;
//	}
//
//	public void saveTpJsonStatus(ContentTpTata contentTpTata) {
//		contentTpTata.setJsonstatus(true);
//		contentTpTataRepository.save(contentTpTata);
//	}
}
