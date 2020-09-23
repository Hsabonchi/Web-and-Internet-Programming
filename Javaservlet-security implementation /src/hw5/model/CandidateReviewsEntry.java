package hw5.model;

import java.util.ArrayList;
import java.util.List;

public class CandidateReviewsEntry {
	int mID;
	double mRating = -1;
	String mName, mSpecialties, mPresentation;
	List<FeedbackEntry> fEntries = new ArrayList<FeedbackEntry>();

	public CandidateReviewsEntry() {
	}
	public CandidateReviewsEntry(int id, String name, String specialties, String presentation) {
		mID = id;
		mName = name;
		mSpecialties = specialties;
		mPresentation = presentation;
	}
	public CandidateReviewsEntry(int id,double rating, String name, String specialties, String presentation) {
		mID = id;
		mRating = rating;
		mName = name;
		mSpecialties = specialties;
		mPresentation = presentation;
	}

	public CandidateReviewsEntry(int id, String name, String specialties, String presentation,
			List<FeedbackEntry> fEntries, double mRating) {
		mID = id;
		mName = name;
		mSpecialties = specialties;
		mPresentation = presentation;
		this.fEntries = fEntries;
		this.mRating = mRating;
	}

	public int getmID() {
		return mID;
	}

	public void setmID(int mID) {
		this.mID = mID;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmSpecialties() {
		return mSpecialties;
	}

	public void setmSpecialties(String mSpecialties) {
		this.mSpecialties = mSpecialties;
	}

	public String getmPresentation() {
		return mPresentation;
	}

	public void setmPresentation(String mPresentation) {
		this.mPresentation = mPresentation;
	}

	public double getmRating() {
		return mRating;
	}

	public void setmRating(double mRating) {
		this.mRating = mRating;
	}

	public List<FeedbackEntry> getfEntries() {
		return fEntries;
	}

	public void setfEntries(List<FeedbackEntry> fEntries) {
		this.fEntries = fEntries;
	}

}
