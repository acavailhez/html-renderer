package acavailhez.html.traits.bootstrap

import acavailhez.html.traits.Html5Trait

// shortcuts for bootstrap 4 modals
// http://v4-alpha.getbootstrap.com/components/modal/
trait Bootstrap4ModalTrait extends Html5Trait {

    // shortcut
    void bootstrapModal(Map attrs,
                        Closure body) {
        bootstrapModal(attrs, null, body, null)
    }

    // shortcut
    void bootstrapModal(Map attrs,
                        Closure body,
                        Closure footer) {
        bootstrapModal(attrs, null, body, footer)
    }

    // A bootstrap modal with basic options
    // if header is null, a default header will be added
    // if footer is null, no footer will be added
    // Available attributes:
    // title, String: if present and header is null, the modal will have a head with this string (escaped)
    // tabindex, int: if present will set the tab-index
    // closeLabel, String: the label of the close cross
    void bootstrapModal(Map attrs,
                        Closure header,
                        Closure body,
                        Closure footer) {

        scopeAttrs(attrs)

        int tabindex = getAttr('tabindex', Integer, -1)
        String title = optAttr('title', String)
        String close = optAttr('closeLabel', String)

        div(class: 'modal fade', tabindex: tabindex, role: 'dialog') {
            div(class: 'modal-dialog') {
                div(class: 'modal-content') {
                    div(class: 'modal-header') {
                        if (header) {
                            header()
                        } else {
                            // default header
                            button(type: 'button', class: 'close', 'data-dismiss': 'modal', 'aria-label': close) {
                                html << '<span aria-hidden="true">&times;</span>'
                            }
                            if (title && !title.isEmpty()) {
                                h4(class: 'modal-title') {
                                    escape << title
                                }
                            }
                        }
                    }
                    div(class: 'modal-body') {
                        body()
                    }
                    if (footer) {
                        div(class: 'modal-footer') {
                            footer()
                        }
                    }
                }
            }

        }
    }

}
