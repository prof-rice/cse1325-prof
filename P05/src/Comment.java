import java.util.ArrayList;

public class Comment {
    public Comment(String text, Person author, Comment inReplyTo) {
        if(text == null || author == null || text.isEmpty())
           throw new IllegalArgumentException("Invalid comment argument");
        this.text = text;
        this.author = author;
        this.inReplyTo = inReplyTo;
        this.replies = new ArrayList<>();
    }
    public void addReply(String text, Person author) {
        if(text == null || author == null || text.isEmpty())
           throw new IllegalArgumentException("Invalid reply argument");
        Comment reply = new Comment(text, author, this);
        replies.add(reply);
    }
    public int numReplies() {
        return replies.size();
    }
    public Comment getReply(int index) {
        return replies.get(index);
    }
    public Comment getInReplyTo() {
        return inReplyTo;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Comment by " + author);
        if(inReplyTo != null) sb.append(" in reply to " + inReplyTo.author);
        if(replies.size() > 0) {
            sb.append("\nReplies: ");
            for(int i=0; i<replies.size(); ++i) {
                if(i > 0 && i%4 == 0) sb.append("\n         ");
                sb.append(String.format("%15s", "(" + i + ") " + 
                    replies.get(i).author.getName()));
            }
        }
        sb.append("\n" + text);
        return sb.toString();
    }

    private String text;
    private Person author;
    private Comment inReplyTo;
    private ArrayList<Comment> replies;
}
