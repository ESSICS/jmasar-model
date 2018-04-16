package se.esss.ics.masar.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Folder extends Node {

	private List<Node> childNodes = new ArrayList<>();

	@Builder
	public Folder(int id, String name, Date created, Date lastModified, Node parent, List<Node> childNodes) {
		super(id, name, created, lastModified, parent, NodeType.FOLDER);
		this.childNodes = childNodes;
	}

	@Override
	public NodeType getNodeType() {
		return NodeType.FOLDER;
	}
}
