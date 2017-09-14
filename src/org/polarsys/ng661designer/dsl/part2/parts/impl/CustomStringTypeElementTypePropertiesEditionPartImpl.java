/**
 * Copyright (c) 2015, 2017 Airbus.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.polarsys.ng661designer.dsl.part2.parts.impl;

// Start of user code for imports
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.polarsys.ng661designer.dsl.part2.parts.CustomStringTypeElementTypePropertiesEditionPart;
import org.polarsys.ng661designer.dsl.part2.parts.Part2ViewsRepository;
import org.polarsys.ng661designer.dsl.part2.providers.Part2Messages;

import org.polarsys.ng661designer.eef.parts.DefaultValueCompositePropertiesEditionPart;

// End of user code

/**
 * 
 * 
 */
public class CustomStringTypeElementTypePropertiesEditionPartImpl extends DefaultValueCompositePropertiesEditionPart implements ISWTPropertiesEditionPart, CustomStringTypeElementTypePropertiesEditionPart {

	protected Text name;
	protected Text maxLength;
	protected Text minLength;
	protected Text regex;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public CustomStringTypeElementTypePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(view);
		return view;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(Composite view) { 
		CompositionSequence customStringTypeElementTypeStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = customStringTypeElementTypeStep.addStep(Part2ViewsRepository.CustomStringTypeElementType.Properties.class);
		propertiesStep.addStep(Part2ViewsRepository.CustomStringTypeElementType.Properties.name);
		propertiesStep.addStep(Part2ViewsRepository.CustomStringTypeElementType.Properties.maxLength);
		propertiesStep.addStep(Part2ViewsRepository.CustomStringTypeElementType.Properties.minLength);
		propertiesStep.addStep(Part2ViewsRepository.CustomStringTypeElementType.Properties.regex);
		
		
		composer = new PartComposer(customStringTypeElementTypeStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == Part2ViewsRepository.CustomStringTypeElementType.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == Part2ViewsRepository.CustomStringTypeElementType.Properties.name) {
					return createNameText(parent);
				}
				if (key == Part2ViewsRepository.CustomStringTypeElementType.Properties.maxLength) {
					return createMaxLengthText(parent);
				}
				if (key == Part2ViewsRepository.CustomStringTypeElementType.Properties.minLength) {
					return createMinLengthText(parent);
				}
				if (key == Part2ViewsRepository.CustomStringTypeElementType.Properties.regex) {
					return createRegexText(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(Part2Messages.CustomStringTypeElementTypePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, Part2ViewsRepository.CustomStringTypeElementType.Properties.name, Part2Messages.CustomStringTypeElementTypePropertiesEditionPart_NameLabel);
		name = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CustomStringTypeElementTypePropertiesEditionPartImpl.this, Part2ViewsRepository.CustomStringTypeElementType.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
			}

		});
		name.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CustomStringTypeElementTypePropertiesEditionPartImpl.this, Part2ViewsRepository.CustomStringTypeElementType.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, Part2ViewsRepository.CustomStringTypeElementType.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(Part2ViewsRepository.CustomStringTypeElementType.Properties.name, Part2ViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	
	protected Composite createMaxLengthText(Composite parent) {
		createDescription(parent, Part2ViewsRepository.CustomStringTypeElementType.Properties.maxLength, Part2Messages.CustomStringTypeElementTypePropertiesEditionPart_MaxLengthLabel);
		maxLength = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData maxLengthData = new GridData(GridData.FILL_HORIZONTAL);
		maxLength.setLayoutData(maxLengthData);
		maxLength.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CustomStringTypeElementTypePropertiesEditionPartImpl.this, Part2ViewsRepository.CustomStringTypeElementType.Properties.maxLength, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxLength.getText()));
			}

		});
		maxLength.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CustomStringTypeElementTypePropertiesEditionPartImpl.this, Part2ViewsRepository.CustomStringTypeElementType.Properties.maxLength, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxLength.getText()));
				}
			}

		});
		EditingUtils.setID(maxLength, Part2ViewsRepository.CustomStringTypeElementType.Properties.maxLength);
		EditingUtils.setEEFtype(maxLength, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(Part2ViewsRepository.CustomStringTypeElementType.Properties.maxLength, Part2ViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createMaxLengthText

		// End of user code
		return parent;
	}

	
	protected Composite createMinLengthText(Composite parent) {
		createDescription(parent, Part2ViewsRepository.CustomStringTypeElementType.Properties.minLength, Part2Messages.CustomStringTypeElementTypePropertiesEditionPart_MinLengthLabel);
		minLength = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData minLengthData = new GridData(GridData.FILL_HORIZONTAL);
		minLength.setLayoutData(minLengthData);
		minLength.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CustomStringTypeElementTypePropertiesEditionPartImpl.this, Part2ViewsRepository.CustomStringTypeElementType.Properties.minLength, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, minLength.getText()));
			}

		});
		minLength.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CustomStringTypeElementTypePropertiesEditionPartImpl.this, Part2ViewsRepository.CustomStringTypeElementType.Properties.minLength, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, minLength.getText()));
				}
			}

		});
		EditingUtils.setID(minLength, Part2ViewsRepository.CustomStringTypeElementType.Properties.minLength);
		EditingUtils.setEEFtype(minLength, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(Part2ViewsRepository.CustomStringTypeElementType.Properties.minLength, Part2ViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createMinLengthText

		// End of user code
		return parent;
	}

	
	protected Composite createRegexText(Composite parent) {
		createDescription(parent, Part2ViewsRepository.CustomStringTypeElementType.Properties.regex, Part2Messages.CustomStringTypeElementTypePropertiesEditionPart_RegexLabel);
		regex = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData regexData = new GridData(GridData.FILL_HORIZONTAL);
		regex.setLayoutData(regexData);
		regex.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CustomStringTypeElementTypePropertiesEditionPartImpl.this, Part2ViewsRepository.CustomStringTypeElementType.Properties.regex, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, regex.getText()));
			}

		});
		regex.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CustomStringTypeElementTypePropertiesEditionPartImpl.this, Part2ViewsRepository.CustomStringTypeElementType.Properties.regex, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, regex.getText()));
				}
			}

		});
		EditingUtils.setID(regex, Part2ViewsRepository.CustomStringTypeElementType.Properties.regex);
		EditingUtils.setEEFtype(regex, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(Part2ViewsRepository.CustomStringTypeElementType.Properties.regex, Part2ViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createRegexText

		// End of user code
		return parent;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.example.ng661.part2.parts.CustomStringTypeElementTypePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.example.ng661.part2.parts.CustomStringTypeElementTypePropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		boolean eefElementEditorDefaultValueState = isDefault(Part2ViewsRepository.CustomStringTypeElementType.Properties.name, newValue);
		if (eefElementEditorDefaultValueState) {
			name.setFont(JFaceResources.getFontRegistry().getItalic(JFaceResources.DEFAULT_FONT));
		} else {
			name.setFont(JFaceResources.getFontRegistry().defaultFont());
		}
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(Part2ViewsRepository.CustomStringTypeElementType.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(Part2Messages.CustomStringTypeElementType_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.example.ng661.part2.parts.CustomStringTypeElementTypePropertiesEditionPart#getMaxLength()
	 * 
	 */
	public String getMaxLength() {
		return maxLength.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.example.ng661.part2.parts.CustomStringTypeElementTypePropertiesEditionPart#setMaxLength(String newValue)
	 * 
	 */
	public void setMaxLength(String newValue) {
		boolean eefElementEditorDefaultValueState = isDefault(Part2ViewsRepository.CustomStringTypeElementType.Properties.maxLength, newValue);
		if (eefElementEditorDefaultValueState) {
			maxLength.setFont(JFaceResources.getFontRegistry().getItalic(JFaceResources.DEFAULT_FONT));
		} else {
			maxLength.setFont(JFaceResources.getFontRegistry().defaultFont());
		}
		if (newValue != null) {
			maxLength.setText(newValue);
		} else {
			maxLength.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(Part2ViewsRepository.CustomStringTypeElementType.Properties.maxLength);
		if (eefElementEditorReadOnlyState && maxLength.isEnabled()) {
			maxLength.setEnabled(false);
			maxLength.setToolTipText(Part2Messages.CustomStringTypeElementType_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !maxLength.isEnabled()) {
			maxLength.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.example.ng661.part2.parts.CustomStringTypeElementTypePropertiesEditionPart#getMinLength()
	 * 
	 */
	public String getMinLength() {
		return minLength.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.example.ng661.part2.parts.CustomStringTypeElementTypePropertiesEditionPart#setMinLength(String newValue)
	 * 
	 */
	public void setMinLength(String newValue) {
		boolean eefElementEditorDefaultValueState = isDefault(Part2ViewsRepository.CustomStringTypeElementType.Properties.minLength, newValue);
		if (eefElementEditorDefaultValueState) {
			minLength.setFont(JFaceResources.getFontRegistry().getItalic(JFaceResources.DEFAULT_FONT));
		} else {
			minLength.setFont(JFaceResources.getFontRegistry().defaultFont());
		}
		if (newValue != null) {
			minLength.setText(newValue);
		} else {
			minLength.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(Part2ViewsRepository.CustomStringTypeElementType.Properties.minLength);
		if (eefElementEditorReadOnlyState && minLength.isEnabled()) {
			minLength.setEnabled(false);
			minLength.setToolTipText(Part2Messages.CustomStringTypeElementType_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !minLength.isEnabled()) {
			minLength.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.example.ng661.part2.parts.CustomStringTypeElementTypePropertiesEditionPart#getRegex()
	 * 
	 */
	public String getRegex() {
		return regex.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.example.ng661.part2.parts.CustomStringTypeElementTypePropertiesEditionPart#setRegex(String newValue)
	 * 
	 */
	public void setRegex(String newValue) {
		boolean eefElementEditorDefaultValueState = isDefault(Part2ViewsRepository.CustomStringTypeElementType.Properties.regex, newValue);
		if (eefElementEditorDefaultValueState) {
			regex.setFont(JFaceResources.getFontRegistry().getItalic(JFaceResources.DEFAULT_FONT));
		} else {
			regex.setFont(JFaceResources.getFontRegistry().defaultFont());
		}
		if (newValue != null) {
			regex.setText(newValue);
		} else {
			regex.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(Part2ViewsRepository.CustomStringTypeElementType.Properties.regex);
		if (eefElementEditorReadOnlyState && regex.isEnabled()) {
			regex.setEnabled(false);
			regex.setToolTipText(Part2Messages.CustomStringTypeElementType_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !regex.isEnabled()) {
			regex.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return Part2Messages.CustomStringTypeElementType_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
