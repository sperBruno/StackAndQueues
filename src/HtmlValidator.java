import java.util.*;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {

    public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
        Stack<HtmlTag> openTags = new Stack<>();
        LinkedList<HtmlTag> closeTags = new LinkedList<>();
        Stack<HtmlTag> resultTags = new Stack<>();
        HtmlTag openTag, closeTag;
        HtmlTag currentTag;

        System.out.println("queues of tags");
        System.out.println(tags);

        while (!tags.isEmpty()) {
            currentTag = tags.poll();
            if (!currentTag.isSelfClosing()) {
                if (currentTag.isOpenTag()) {
                    openTags.push(currentTag);
                } else {
                    closeTags.add(currentTag);
                }
            }
        }
        System.out.println("Open tags");
        System.out.println(openTags);
        System.out.println("Close tags");
        System.out.println(closeTags);
        if (openTags.isEmpty() || closeTags.isEmpty() || closeTags.size()>openTags.size()){
            System.out.println("return null");
            return null;
        }
        while (!closeTags.isEmpty() && !openTags.isEmpty()) {
            System.out.println("while2");
            openTag = openTags.pop();
            System.out.println("Open Tag"  + openTag);
            closeTag = closeTags.removeFirst();
            System.out.println("Close Tag" + closeTag);
            System.out.println(openTag.element +"=="+closeTag.element);
            if (!openTag.element.equals(closeTag.element)) {
                System.out.println("adding tag" + openTag);
                resultTags.push(openTag);
                break;
            }

        }
        System.out.println(closeTags);
        System.out.println("Result STACK");
        System.out.println(resultTags);
        System.out.println("Open STACK ");
        System.out.println(openTags);
        return openTags; // this line is here only so this code will compile if you don't modify it
    }


}

