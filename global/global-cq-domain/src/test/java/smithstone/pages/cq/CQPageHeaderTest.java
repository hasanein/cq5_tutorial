package smithstone.pages.cq;

import com.day.cq.wcm.api.Page;
import org.junit.Test;
import org.mockito.Mockito;
import smithstone.pages.PageHeader;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CQPageHeaderTest {

    public static final String NO_TITLE = null;
    public static final String FAKE_PAGE_TITLE = "Mocked Page Title";

    @Test
    public void headerHasTitleFromCQHasTitle() throws Exception {
        CQPageHeader header = new CQPageHeader();
        header.setCqPage(fakePage(FAKE_PAGE_TITLE));
        assertThat(header.getTitle(), equalTo(FAKE_PAGE_TITLE));
    }

    @Test
    public void headerHasDefaultTitleWhenCQPageHasNoTitle() throws Exception {
        CQPageHeader header = new CQPageHeader();
        header.setCqPage(fakePage(NO_TITLE));
        assertThat(header.getTitle(), equalTo(PageHeader.DEFAULT_TITLE));
    }

    private Page fakePage(String title) {
        Page page = Mockito.mock(Page.class);
        Mockito.when(page.getTitle()).thenReturn(title);
        return page;
    }

    @Test
    public void headerHasDefaultTitleWhenCQPageHasNotBeenSet() throws Exception {
        assertThat(new CQPageHeader().getTitle(), equalTo(PageHeader.DEFAULT_TITLE));
    }
}
