package seedu.address.logic;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.parser.Prefix;
import seedu.address.model.person.Person;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_PERSON_DISPLAYED_INDEX = "The person index provided is invalid";
    public static final String MESSAGE_STAFF_LISTED_OVERVIEW = "Found you %1$d staff:\n"
            + "%2$s\nTo show all staffs: stafffind all/true";
    public static final String MESSAGE_CUSTOMERS_LISTED_OVERVIEW = "Found you %1$d customers:\n"
            + "%2$s\nTo show all customers: customerfind all/true";
    public static final String MESSAGE_DUPLICATE_FIELDS =
            "Multiple values specified for the following single-valued field(s): ";
    public static final String MESSAGE_INVALID_CUSTOMER_DISPLAYED_INDEX = "The customer index provided is invalid";
    public static final String MESSAGE_INVALID_STAFF_DISPLAYED_INDEX = "The staff index provided is invalid";
    public static final String MESSAGE_INVALID_DRINK_DISPLAYED_INDEX = "The drink index provided is invalid";

    /**
     * Returns an error message indicating the duplicate prefixes.
     */
    public static String getErrorMessageForDuplicatePrefixes(Prefix... duplicatePrefixes) {
        assert duplicatePrefixes.length > 0;

        Set<String> duplicateFields =
                Stream.of(duplicatePrefixes).map(Prefix::toString).collect(Collectors.toSet());

        return MESSAGE_DUPLICATE_FIELDS + String.join(" ", duplicateFields);
    }

    /**
     * Formats the {@code person} for display to the user.
     */
    public static String format(Person person) {
        final StringBuilder builder = new StringBuilder();
        builder.append(person.getName())
                .append("; Phone: ")
                .append(person.getPhone())
                .append("; Email: ")
                .append(person.getEmail())
                .append("; Address: ")
                .append(person.getAddress())
                .append("; Remark: ")
                .append(person.getRemark())
                .append("; Tags: ");
        person.getTags().forEach(builder::append);
        return builder.toString();
    }

}
