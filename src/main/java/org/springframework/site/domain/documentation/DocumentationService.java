package org.springframework.site.domain.documentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DocumentationService {
	private final Map<String, List<Project>> projectCategoryMap;
	private final List<Project> projects;

	public DocumentationService(Map<String, List<Project>>projectCategoryMap) {
		this.projectCategoryMap = projectCategoryMap;
		projects = new ArrayList<>();
		for (Map.Entry<String, List<Project>> projectCategory : projectCategoryMap.entrySet()) {
			projects.addAll(projectCategory.getValue());
		}
	}

	public List<Project> getProjectsForCategory(String category) {
		return projectCategoryMap.get(category);
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public Project getProject(String id) {
		for (Project project : projects) {
			if (project.getId().equals(id)) {
				return project;
			}
		}
		return null;
	}
}
