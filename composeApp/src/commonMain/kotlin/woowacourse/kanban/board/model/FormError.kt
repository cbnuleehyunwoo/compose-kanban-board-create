package woowacourse.kanban.board.model

enum class FormError(val message: String) {
    TITLE_FORM_INVALID("제목을 입력해주세요."),
    TAG_OVER_N("태그는 5자 이내로 5개 까지만 등록할 수 있습니다."),
    TAG_FORM_INVALID("태그 형식이 올바르지 않습니다."),
}
