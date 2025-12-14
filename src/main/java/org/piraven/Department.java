package org.piraven;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
public class Department {
    private String departmentId;
    private String departmentName;

    private static int nextId = 1;

    /**
     * Checks if the department name is valid or not
     * @param departmentName the input department name
     * @return the department name is valid or not
     */
    private static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null || departmentName.isEmpty()) {
            return false;
        }

        for (char c : departmentName.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }

        return true;
    }

    public Department(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentName = Util.toTitleCase(departmentName);
            this.departmentId = String.format("D%02d", nextId++);
        } else {
            this.departmentName = null;
            this.departmentId = null;
        }
    }

    public void setDepartmentName(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentName = Util.toTitleCase(departmentName);
        } else {
            this.departmentName = null;
            this.departmentId = null;
        }
    }
}
