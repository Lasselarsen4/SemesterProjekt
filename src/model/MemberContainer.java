package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MemberContainer {
	
	private static MemberContainer instance;
	private List<Member> members;
	private Comparator<Member> memberComparator;
	
	/**
	 * Opretter en privat constructor for at sikre,
	 * at der kun kan oprettes én instans af MemberContainer.
	 * Constructor kan kun kaldes via getInstance-metoden.
	 */
	private MemberContainer() {
		members = new ArrayList<>();
		memberComparator = (m1, m2) -> m1.getEmail().compareTo(m2.getEmail());
	}
	
	/**
	 * @return instansen af MemberContainer
	 */
	public static MemberContainer getInstance() {
		if (instance == null) {
			instance = new MemberContainer();
		}
		return instance;
	}
	
	/**
	 * Tilføjer et medlem til containeren.
	 * @param member medlemmet, der skal tilføjes
	 */
	public void addMember(Member member) {
		if (member != null) {
			members.add(member);
			sortMembers();
		}
	}
	
	/**
	 * Finder et medlem i containeren ud fra e-mailadressen.
	 * @param email e-mailadressen, der skal søges efter
	 * @return det medlem, der matcher e-mailadressen, eller null hvis intet match findes
	 */
	public Member findMemberByEmail(String email) {
		sortMembers();
		Member result = null;
		try {
			int index = Collections.binarySearch(members, new Member(0, null, email, null, null), memberComparator);
			result = members.get(index);
		} catch (IndexOutOfBoundsException e) {
			return result;
		}
		return result;
	}
	
	/**
	 * Sorterer medlemmerne i containeren.
	 */
	private void sortMembers() {
		Collections.sort(members, memberComparator);
	}
	
	/**
	 * @return en liste med alle medlemmer i containeren
	 */
	public List<Member> getAllMembers() {
		return members;
	}
	
}