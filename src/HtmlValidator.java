import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {

    public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
        Stack<HtmlTag> openTags = new Stack<>();
        Stack<HtmlTag> closeTags = new Stack<>();
        Stack<HtmlTag> resultTags = new Stack<>();
        HtmlTag openTag, closeTag;
        HtmlTag currentTag;

     //   for (HtmlTag item : tags){
        //       System.out.println(item);
        //}

        while (!tags.isEmpty()) {
            currentTag = tags.poll();
            if (currentTag.isOpenTag() && !currentTag.isSelfClosing()) {
                openTags.push(currentTag);
            } else if (!currentTag.isSelfClosing() && !currentTag.isOpenTag()) {
                closeTags.push(currentTag);
            }
        }
        int count = 0;
        while (openTags.empty()) {
            count++;
            openTag = openTags.pop();
            System.out.println("Open Tag" +count +"  "+ openTag);
            closeTag = closeTags.pop();
            System.out.println("Close Tag"+count +"  " + closeTag);
            if (openTag.matches(closeTag)) {
                resultTags.push(openTag);
            }
        }

        return resultTags; // this line is here only so this code will compile if you don't modify it
    }


}

