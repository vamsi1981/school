package com.pkg.ActionForm;

import org.apache.struts.action.ActionForm;

import com.pkg.bean.TimeTableCmnBean;
import com.pkg.hibernate.Calender;
import com.pkg.hibernate.Category;
import com.pkg.hibernate.Classlevel;
import com.pkg.hibernate.Complexity;
import com.pkg.hibernate.Event;
import com.pkg.hibernate.Exam;
import com.pkg.hibernate.ExamSchedule;
import com.pkg.hibernate.FocusAreas;
import com.pkg.hibernate.Format;
import com.pkg.hibernate.GeneralInfo;
import com.pkg.hibernate.Grades;
import com.pkg.hibernate.Graphs;
import com.pkg.hibernate.GroupType;
import com.pkg.hibernate.Guardian;
import com.pkg.hibernate.HelpSc;
import com.pkg.hibernate.NewsAndEvents;
import com.pkg.hibernate.NonNativeStudent;
import com.pkg.hibernate.Period;
import com.pkg.hibernate.PersonGroup;
import com.pkg.hibernate.SpecialSubject;
import com.pkg.hibernate.Status;
import com.pkg.hibernate.SubTopics;
import com.pkg.hibernate.Subject;
import com.pkg.hibernate.Task;
import com.pkg.hibernate.TeacherToSubject;
import com.pkg.hibernate.Test;
import com.pkg.hibernate.TimeTable;
import com.pkg.bean.TimeTableCmnBean;

public class SchoolMasterDataForm extends ActionForm  {

	public Category category;
	public String deleteProperty;
	public String addCategory;
	public String addCategoryType;
	public String addCategoryButton;
	public Classlevel classlevel;
	public Complexity complexity;
	public Event event;
	public Exam exam;
	public Format format;
	public GeneralInfo generalInfo;
	public Grades grades;
	public Graphs graphs;
	public GroupType groupType;
	public Guardian guardian;
	public Calender calender;
	public String calenderdate;
	public NewsAndEvents newsAndEvents;
	public HelpSc helpSc;
	public String newsAndEventsStartDate;
	public NonNativeStudent nonNativeStudent;
	public Period period;
	public String periodStartTimeHours;
	public String periodEndTimeHours;
	public String periodStartTimeMinutes;
	public String periodEndTimeMinutes;
	public String periodStartAMorPM;
	public String periodEndAMorPM;
	public String personGroupDate;
	public PersonGroup personGroup;
	public SpecialSubject specialSubject;
	public Status status;
	public FocusAreas focusAreas;
	public SubTopics subTopics;
	public Test test;
	public Task task;
	public Subject subject;
	public TeacherToSubject teacherToSubject;
	public String teachertoSubjectStartDate;
	public String teachertoSubjectendDate;
	public ExamSchedule examSchedule;
	public String examScheduleStartDate;
	public String examScheduleEndDate;
	public TimeTableOptions timeTableOptions;
	public TimeTable timeTable;	
	public TimeTableCmnBean timeTableCmnBean;



	public SchoolMasterDataForm() {
		timeTableCmnBean = new TimeTableCmnBean();
		timeTableOptions =new TimeTableOptions();
		examSchedule = new ExamSchedule();
		category = new Category();
		classlevel = new Classlevel();
		complexity = new Complexity();
		event = new Event();
		exam = new Exam();
		format = new Format();
		generalInfo = new GeneralInfo();
		grades = new Grades();
		graphs = new Graphs();
		groupType = new GroupType();
		guardian = new Guardian();
		calender = new Calender();
		newsAndEvents = new NewsAndEvents();
		helpSc = new HelpSc();
		nonNativeStudent = new NonNativeStudent();
		period =new Period();
		personGroup =new PersonGroup();
		specialSubject = new SpecialSubject();
		status = new Status();
		focusAreas = new FocusAreas();
		subTopics =new SubTopics();
		test = new Test();
		task = new Task();
		subject = new Subject();
		teacherToSubject = new TeacherToSubject();
		timeTable = new TimeTable();
	}
	
	public TimeTableCmnBean getTimeTableCmnBean() {
		return timeTableCmnBean;
	}

	public void setTimeTableCmnBean(TimeTableCmnBean timeTableCmnBean) {
		this.timeTableCmnBean = timeTableCmnBean;
	}
	
	public TimeTable getTimeTable() {
		return timeTable;
	}

	public void setTimeTable(TimeTable timeTable) {
		this.timeTable = timeTable;
	}

	public TimeTableOptions getTimeTableOptions() {
		return timeTableOptions;
	}

	public void setTimeTableOptions(TimeTableOptions timeTableOptions) {
		this.timeTableOptions = timeTableOptions;
	}

	public String getExamScheduleStartDate() {
		return examScheduleStartDate;
	}

	public void setExamScheduleStartDate(String examScheduleStartDate) {
		this.examScheduleStartDate = examScheduleStartDate;
	}

	public String getExamScheduleEndDate() {
		return examScheduleEndDate;
	}

	public void setExamScheduleEndDate(String examScheduleEndDate) {
		this.examScheduleEndDate = examScheduleEndDate;
	}

	public String getTeachertoSubjectStartDate() {
		return teachertoSubjectStartDate;
	}

	public void setTeachertoSubjectStartDate(String teachertoSubjectStartDate) {
		this.teachertoSubjectStartDate = teachertoSubjectStartDate;
	}

	public String getTeachertoSubjectendDate() {
		return teachertoSubjectendDate;
	}

	public void setTeachertoSubjectendDate(String teachertoSubjectendDate) {
		this.teachertoSubjectendDate = teachertoSubjectendDate;
	}

	public ExamSchedule getExamSchedule() {
		return examSchedule;
	}

	public void setExamSchedule(ExamSchedule examSchedule) {
		this.examSchedule = examSchedule;
	}

	public TeacherToSubject getTeacherToSubject() {
		return teacherToSubject;
	}

	public void setTeacherToSubject(TeacherToSubject teacherToSubject) {
		this.teacherToSubject = teacherToSubject;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public SubTopics getSubTopics() {
		return subTopics;
	}

	public void setSubTopics(SubTopics subTopics) {
		this.subTopics = subTopics;
	}

	public FocusAreas getFocusAreas() {
		return focusAreas;
	}

	public void setFocusAreas(FocusAreas focusAreas) {
		this.focusAreas = focusAreas;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getPersonGroupDate() {
		return personGroupDate;
	}


	public void setPersonGroupDate(String personGroupDate) {
		this.personGroupDate = personGroupDate;
	}



	public SpecialSubject getSpecialSubject() {
		return specialSubject;
	}

	public void setSpecialSubject(SpecialSubject specialSubject) {
		this.specialSubject = specialSubject;
	}

	public String getPeriodStartAMorPM() {
		return periodStartAMorPM;
	}


	public void setPeriodStartAMorPM(String periodStartAMorPM) {
		this.periodStartAMorPM = periodStartAMorPM;
	}


	public PersonGroup getPersonGroup() {
		return personGroup;
	}

	public void setPersonGroup(PersonGroup personGroup) {
		this.personGroup = personGroup;
	}

	public String getPeriodEndAMorPM() {
		return periodEndAMorPM;
	}


	public void setPeriodEndAMorPM(String periodEndAMorPM) {
		this.periodEndAMorPM = periodEndAMorPM;
	}




	public String getPeriodStartTimeHours() {
		return periodStartTimeHours;
	}

	public void setPeriodStartTimeHours(String periodStartTimeHours) {
		this.periodStartTimeHours = periodStartTimeHours;
	}

	public String getPeriodEndTimeHours() {
		return periodEndTimeHours;
	}

	public void setPeriodEndTimeHours(String periodEndTimeHours) {
		this.periodEndTimeHours = periodEndTimeHours;
	}

	public String getPeriodStartTimeMinutes() {
		return periodStartTimeMinutes;
	}

	public void setPeriodStartTimeMinutes(String periodStartTimeMinutes) {
		this.periodStartTimeMinutes = periodStartTimeMinutes;
	}

	public String getPeriodEndTimeMinutes() {
		return periodEndTimeMinutes;
	}

	public void setPeriodEndTimeMinutes(String periodEndTimeMinutes) {
		this.periodEndTimeMinutes = periodEndTimeMinutes;
	}



	public String getNewsAndEventsStartDate() {
		return newsAndEventsStartDate;
	}
	public void setNewsAndEventsStartDate(String newsAndEventsStartDate) {
		this.newsAndEventsStartDate = newsAndEventsStartDate;
	}
	public Period getPeriod() {
		return period;
	}
	public void setPeriod(Period period) {
		this.period = period;
	}
	public NonNativeStudent getNonNativeStudent() {
		return nonNativeStudent;
	}
	public void setNonNativeStudent(NonNativeStudent nonNativeStudent) {
		this.nonNativeStudent = nonNativeStudent;
	}
	public HelpSc getHelpSc() {
		return helpSc;
	}
	public void setHelpSc(HelpSc helpSc) {
		this.helpSc = helpSc;
	}
	public NewsAndEvents getNewsAndEvents() {
		return newsAndEvents;
	}
	public void setNewsAndEvents(NewsAndEvents newsAndEvents) {
		this.newsAndEvents = newsAndEvents;
	}
	public String getCalenderdate() {
		return calenderdate;
	}

	public void setCalenderdate(String calenderdate) {
		this.calenderdate = calenderdate;
	}

	public Calender getCalender() {
		return calender;
	}

	public void setCalender(Calender calender) {
		this.calender = calender;
	}

	public Guardian getGuardian() {
		return guardian;
	}

	public void setGuardian(Guardian guardian) {
		this.guardian = guardian;
	}

	public GroupType getGroupType() {
		return groupType;
	}

	public void setGroupType(GroupType groupType) {
		this.groupType = groupType;
	}

	public Graphs getGraphs() {
		return graphs;
	}

	public void setGraphs(Graphs graphs) {
		this.graphs = graphs;
	}

	public Grades getGrades() {
		return grades;
	}

	public void setGrades(Grades grades) {
		this.grades = grades;
	}

	public GeneralInfo getGeneralInfo() {
		return generalInfo;
	}

	public void setGeneralInfo(GeneralInfo generalInfo) {
		this.generalInfo = generalInfo;
	}

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Complexity getComplexity() {
		return complexity;
	}

	public void setComplexity(Complexity complexity) {
		this.complexity = complexity;
	}

	public String addClassType;
	public String addClassId;
	public String addClassSection;

	public String getAddClassType() {
		return addClassType;
	}

	public void setAddClassType(String addClassType) {
		this.addClassType = addClassType;
	}

	public String getAddClassId() {
		return addClassId;
	}

	public void setAddClassId(String addClassId) {
		this.addClassId = addClassId;
	}

	public String getAddClassSection() {
		return addClassSection;
	}

	public void setAddClassSection(String addClassSection) {
		this.addClassSection = addClassSection;
	}

	public Classlevel getClasslevel() {
		return classlevel;
	}

	public void setClasslevel(Classlevel classlevel) {
		this.classlevel = classlevel;
	}



	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;

	}


	public String getDeleteProperty() {
		return deleteProperty;
	}

	public void setDeleteProperty(String deleteProperty) {
		this.deleteProperty = deleteProperty;
	}

	public String getAddCategory() {
		return addCategory;
	}

	public void setAddCategory(String addCategory) {
		this.addCategory = addCategory;
	}

	public String getAddCategoryType() {
		return addCategoryType;
	}

	public void setAddCategoryType(String addCategoryType) {
		this.addCategoryType = addCategoryType;
	}

	public String getAddCategoryButton() {
		return addCategoryButton;
	}

	public void setAddCategoryButton(String addCategoryButton) {
		this.addCategoryButton = addCategoryButton;
	}


}
